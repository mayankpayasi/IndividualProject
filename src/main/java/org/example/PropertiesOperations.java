package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesOperations {

    //object of property file
    Properties prop=new Properties();

    public String getPropertyFileData(String key) throws IOException {
        //load data first

        String propFilePath=System.getProperty("user.dir")+ "/src/main/java/org/example/config.properties";
        FileInputStream fis=new FileInputStream(propFilePath);
        prop.load(fis);

        //read data
        String value=prop.get(key).toString();
        return value;

    }
}