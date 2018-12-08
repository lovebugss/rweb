package com.itrjp.rweb.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertiesService {
	/**
	 * 文件存储路径
	 */
	public static String REPOSITORY_PATH;
	/**
	 * 文件访问路径
	 */
	public static String IMAGE_BASE_URL;
	
	
	@Value("${file.base.path}")
	public void setREPOSITORY_PATH(String rEPOSITORY_PATH) {
		REPOSITORY_PATH = rEPOSITORY_PATH;
	}
	@Value("${base.url}")
	public void setIMAGE_BASE_URL(String iMAGE_BASE_URL) {
		IMAGE_BASE_URL = iMAGE_BASE_URL;
	}

}
