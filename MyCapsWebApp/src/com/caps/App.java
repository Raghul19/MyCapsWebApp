package com.caps;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.log4j.Logger;

public class App 
{
	final static Logger logger = Logger.getLogger(App.class);
	public static void main(String[] args) 
	{
		logger.info("program started...");
		try {
			logger.info("Giving file path");
			String path = "‪F://Capgemini//App.txt";
			logger.info("Creating file reader object");
			FileReader in = new FileReader(path);
			logger.info("Creating Bufferedreader object and passing filereader ref ");
			BufferedReader reader = new BufferedReader(in);
			logger.info("file reading started");
			String line = null;
			while((line = reader.readLine())!= null) {
				System.out.println(line);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("program ended..");
	}
}
