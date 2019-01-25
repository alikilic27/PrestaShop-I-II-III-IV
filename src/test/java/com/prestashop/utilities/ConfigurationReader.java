package com.prestashop.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

    static {

        String path = "configuration.properties";

        try{
            //java can't read files directly, it needs to inputstream to read files
            //inputstream takes the location of the file as a constructor
            FileInputStream fileInputStream = new FileInputStream(path);

            //properties class is used to read specifically Properties file, files with key value pairs
            properties = new Properties();

            //file contents are load to properties from the inputstream
            properties.load(fileInputStream);

            //all input streams must be closed
            fileInputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //returns the value of specific property
    public static String getProperty(String propety){
        return properties.getProperty(propety);
    }
}
