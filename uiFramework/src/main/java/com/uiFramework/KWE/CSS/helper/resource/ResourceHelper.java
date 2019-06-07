package com.uiFramework.KWE.CSS.helper.resource;

public class ResourceHelper {

	
	public static String getResourcePath(String path)
	{
		String basePath = System.getProperty("user.dir");
		return basePath+path;
	}
}
