package managers;

import dataProvider.ConfigFileReader;

public class FileReaderManager {
	
	//this is a singleton class to make sure there is only single object
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configfileReader;
	
	private FileReaderManager() {
	}
	
	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}
	
	public  ConfigFileReader getConfigReader() {
		return(configfileReader == null )?new ConfigFileReader():configfileReader;
	}

}