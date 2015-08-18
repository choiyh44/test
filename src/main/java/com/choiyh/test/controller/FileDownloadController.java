package com.choiyh.test.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownloadController {

	/**
	 * Method for handling file download request from client
	 */
	@RequestMapping(value = "/attachment/{attachmentId}")
	public String doDownload(Integer attachmentId, Model model) throws IOException {
		// 첨부 파일 정보
		Map<String, Object> fileInfo = new HashMap<String, Object>();
		fileInfo.put("fileUploadPath", "c:/Temp");
		fileInfo.put("fileLogicName", "한글파일명테스트.txt");
		fileInfo.put("filePhysicName", "blog_post_search.xml");
		model.addAttribute("downloadFile", fileInfo);

		return "fileDownloadView";
	}

}
