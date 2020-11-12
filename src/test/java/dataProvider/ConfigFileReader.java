package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import enums.DriverType;

public class ConfigFileReader {
	private Properties properties;
	//filepath is the path to the config file
	private final String propertyFilePath = "configs/Configuration.properties";  	
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			//new FileReader(path)-creates new file reader from the file given to read from 
			//new bufferedReader()- reads text from the character input stream, 
			//buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
			reader = new BufferedReader(new FileReader(propertyFilePath)); 
			properties=new Properties(); //creating object of properties
			try {
				properties.load(reader);  //reads the property file as key-value pair
				reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration file is not present at - "+propertyFilePath);
		}
	}
	
	public String getDriverPath() {
		//getproperties- properties object has a method getProperty to get the value of the key mentioned in paranthesis.
		//if the value is null i.e. not defined in config file, 
		//then it will show error else value will be returned.
		String driverPath = properties.getProperty("driverPath");
		if (driverPath!=null) {
			return driverPath;
		}else{
			throw new RuntimeException("driverpath is not defined in the config file.");
		}
	}
	
	public long getImplicitlyWait() {
		String implicitlyWait=properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			return Long.parseLong(implicitlyWait);
		}else {
			throw new RuntimeException("Implicit wait is not defined in config file");
		}
	}

	public String getApplicationUrl() {
		String url=properties.getProperty("url");
		if(url != null) {
			return url;
		}else {
			throw new RuntimeException("url is not defined in config file");
		}
	}
	
	public DriverType getBrowser() {
		String browserName=properties.getProperty("browser");
		if(browserName == null || browserName.equalsIgnoreCase("chrome")) return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browserName.equalsIgnoreCase("safari")) return DriverType.SAFARI;
		else throw new RuntimeException("broswer name not matched in config file - "+browserName);
	}
	
	
	public boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}
	
}
