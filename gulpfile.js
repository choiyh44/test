var gulp = require('gulp');
var connect = require('gulp-connect');
var _ = require('lodash');
var uglify = require('gulp-uglify');
var concat = require('gulp-concat');
var runSequence = require('run-sequence');
var rename = require('gulp-rename');
var copy = require('gulp-copy');
var ngAnnotate = require('gulp-ng-annotate');
var stripDebug = require('gulp-strip-debug');
var cachebust = require('gulp-cache-bust');
var gulpNgConfig = require('gulp-ng-config');

function apiProxy(isLocal) {
    var proxyMiddleware = require('http-proxy-middleware');
    // var target = isLocal ? 'http://local.toastcam.com:8080' : 'https://dev.toastcam.com';
    var target = isLocal ? 'http://local-partnercam.toast.com:8080' : 'https://dev-partnercam.toast.com';
    return proxyMiddleware(
        ['/demo', '/logout', '/json', '/manager', '/admin'],
        {
            target: target,
            changeOrigin: true,
            secure: false
        }
    );
}

function oauthProxy(isLocal) {
    var proxyMiddleware = require('http-proxy-middleware');
    // var target = isLocal ? 'http://local.toastcam.com:8080' : 'https://dev.toastcam.com';
    var target = isLocal ? 'http://local-partnercam.toast.com:8080' : 'https://dev-partnercam.toast.com';

    return proxyMiddleware(
        '/oauth2.0',
        {
            target: target,
            changeOrigin: true,
            pathRewrite: {
                '^/oauth2.0': '/admin'
            },
			secure: false
        }
    );
}

gulp.task('connect', function () {
    connect.server({
        port: 80,
        livereload: true,
        middleware: function(connect, ops) {
            return [apiProxy(false), oauthProxy(false)]
        }
    });
});

gulp.task('connect-local', function () {
    connect.server({
        port: 80,
        livereload: true,
        middleware: function(connect, ops) {
            return [apiProxy(true), oauthProxy(true)]
        }
    });
});

gulp.task('config-alpha', function () {
	return gulp.src('app/constants.json')
		.pipe(gulpNgConfig('ipcam.config', {
			environment: 'alpha'
		}))
		.pipe(gulp.dest('app/'));
});

gulp.task('config-beta', function () {
	return gulp.src('app/constants.json')
		.pipe(gulpNgConfig('ipcam.config', {
			environment: 'beta'
		}))
		.pipe(gulp.dest('app/'));
});

gulp.task('config-real', function () {
	return gulp.src('app/constants.json')
		.pipe(gulpNgConfig('ipcam.config', {
			environment: 'real'
		}))
		.pipe(gulp.dest('app/'));
});

gulp.task('concat', function() {
    return gulp.src(['app/app.js', 'app/util.js', 'app/hashMap.js', 'app/validate.js', 'app/**/*.js'])
        .pipe(concat('bundle.js'))
        .pipe(gulp.dest('resources/dist'));
});


gulp.task('uglify', function() {
    return gulp.src('resources/dist/bundle.js')
				.pipe(stripDebug())
				.pipe(ngAnnotate())
        .pipe(uglify())
        .pipe(rename({ suffix: '.min' }))
        .pipe(gulp.dest('dist'));
});

gulp.task('watch', function() {
    return gulp.watch(['app/**/*.js', 'signout/signout.js'], ['concat']);
});

gulp.task('copy-index-alpha', function() {
    return gulp.src('index.alpha.html')
				.pipe(cachebust({
					type: 'timestamp'
				}))
        .pipe(rename('index.html'))
        .pipe(gulp.dest('dist'));
});

gulp.task('copy-index', function() {
    return gulp.src('index.prod.html')
				.pipe(cachebust({
					type: 'timestamp'
				}))
        .pipe(rename('index.html'))
        .pipe(gulp.dest('dist'));
});

gulp.task('copy-resources-alpha', function() {
    return gulp.src(['favicon.ico', 'robots.txt', 'crossdomain.xml', 'resources/author/**/*', 'resources/css/**/*', 'signout/**/*',
        'resources/im/**/*', 'resources/images/**/*', 'resources/img/*', 'resources/im_b2b/*', 'resources/js_min/**/*', 'resources/stylesheets/**/*', 'resources/vendor/**/*', 'error/*'])
        .pipe(copy('dist'));
});

gulp.task('copy-resources', function() {
    return gulp.src(['favicon.ico', 'robots.txt', 'crossdomain.xml', 'resources/author/**/*', 'resources/css/**/*', 'signout/**/*',
        'resources/im/**/*', 'resources/images/**/*', 'resources/img/*', 'resources/im_b2b/*', 'resources/js_min/**/*', 'resources/stylesheets/**/*', 'resources/vendor/**/*', 'error/*'])
        .pipe(copy('dist'));
});

gulp.task('copy-common', function (){
    return gulp.src(['templates/common/**/*'])
        .pipe(gulp.dest('dist/common'));
});

gulp.task('copy-templates', function() {
    return gulp.src(['templates/**/*'])
        .pipe(copy('dist'));
});

gulp.task('build-alpha', function() {
    runSequence('config-alpha', 'concat', 'uglify', 'copy-index-alpha', 'copy-templates', 'copy-resources-alpha', 'copy-common');
});

gulp.task('build-beta', function() {
    runSequence('config-beta', 'concat', 'uglify', 'copy-index', 'copy-templates', 'copy-resources','copy-common');
});

gulp.task('build', function() {
    runSequence('config-real', 'concat', 'uglify', 'copy-index', 'copy-templates', 'copy-resources', 'copy-common');
});

gulp.task('default', ['config-alpha', 'connect', 'concat', 'watch']);

gulp.task('local', ['config-alpha', 'connect-local', 'concat', 'watch']);
