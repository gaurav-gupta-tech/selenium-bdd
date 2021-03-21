package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadProperties {
    
    private static final String CONFIGFILEPATH = "./config/config.properties";

    public static String getValue(String key)  {
        File file = new File(CONFIGFILEPATH);
        FileInputStream fileInputStream = null;
        Properties properties = null;
        try {
            fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
  
        return properties.getProperty(key);
    }

    public Long getTimeout() throws Exception {
        String timeout = ReadProperties.getValue("timeout");
        return Long.parseLong(timeout);
    }

    public static String getURL() {
        String url = ReadProperties.getValue("url");
        return url;
    }
    public static String getReportConfigPath(){
        String reportConfigPath = ReadProperties.getValue("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

}
