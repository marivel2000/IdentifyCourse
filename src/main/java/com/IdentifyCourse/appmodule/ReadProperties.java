package com.IdentifyCourse.appmodule;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties  {
	static Properties prop = new Properties();
	InputStream readFile = null;
	public ReadProperties(){
		 try 
		 {
			 readFile = new FileInputStream("Resources\\config.properties");
			 prop.load(readFile);
		 } 
		 catch(IOException io)
		 {
			io.printStackTrace();
		 }
		 finally
		  {
			if(readFile!=null)
			{
				try 
				{
					readFile.close();
				} 	
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		 }
	}
	 
		 public String getbrowser()
		 {
			 String browser = prop.getProperty("Browser");
			 return browser;
		 }
			
		 public static  String getUrl()
		 {
		 String url = prop.getProperty("url");
		 return url;
		 }
}
