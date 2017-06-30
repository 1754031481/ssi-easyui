package com.jk.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jk.util.Json;

@Controller
@RequestMapping("/upload")
public class UploadImgController extends BaseController implements ServletContextAware{
	
	private static final Logger logger = Logger
			.getLogger(UploadImgController.class);
	
	private ServletContext servletContext; 

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	@RequestMapping("uploadImg")
	public String handleUploadData(String name,
			@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
		if (!file.isEmpty()) {
			// 获取本地存储路径
			String path = this.servletContext.getRealPath("/upload/");
			logger.info(path);
			String fileName = file.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf("."));
			logger.info(fileType);
			String imgUrl = new Date().getTime() + fileType;
			File file2 = new File(path, imgUrl);
			try {
				// 将上传的文件写入到新建的文件中
				file.getFileItem().write(file2);
			} catch (Exception e) {
				return "404";
			}
			request.setAttribute("imgUrl", "/upload/" + imgUrl);
			return "/WEB-INF/user";
		} else {
			return "404";
		}
	}

}
