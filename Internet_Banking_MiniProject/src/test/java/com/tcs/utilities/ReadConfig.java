package com.tcs.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties pro;

public ReadConfig() 
{
File file=new File("./config_Files/config.properties");


try {
	FileInputStream  fls = new FileInputStream(file);
	pro=new Properties();
	pro.load(fls);
	
   }
 catch (Exception e)
{
	System.out.println("Exception is :"+e.getMessage());
}

}


public String getApplicationURL()
{
	return pro.getProperty("baseURL");
}

public String getUserName()
{
	return pro.getProperty("username");
}

public String getPassword()
{
	return pro.getProperty("password");
}

public String getEdgePath()
{
	return pro.getProperty("edgepath");
}

public String getChromePath()
{
	return pro.getProperty("chromepath");
}

public String getFirefoxPath()
{
	return pro.getProperty("firefoxpath");
}
}
