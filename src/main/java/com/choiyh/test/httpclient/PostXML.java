package com.choiyh.test.httpclient;

import java.io.File;
import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostXML {
	private static final Logger logger = LoggerFactory.getLogger(PostXML.class);

	public void requestIndexing(String filePath) throws IOException {
		String ssfPushUrl = "http://www.naver.com/";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httppost = new HttpPost(ssfPushUrl);

			File file = new File(filePath);
			FileEntity reqEntity = new FileEntity(file, ContentType.TEXT_XML);
			httppost.setEntity(reqEntity);

			logger.debug("Executing request: " + httppost.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				logger.debug(response.getStatusLine().toString());
				String responseData = EntityUtils.toString(response.getEntity());
				logger.info("***** responseData -------------------------");
				logger.info(responseData);
				logger.info("***** -------------------------------------");
				EntityUtils.consume(response.getEntity());
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}
}
