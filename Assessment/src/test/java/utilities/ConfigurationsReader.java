package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationsReader {
    // used to read and implement centralized data stored in the configuration properties
    private static Properties configFile;
    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("Configuration.properties"); // This is the path from content root
            configFile = new Properties();
            configFile.load(fileInputStream);
            fileInputStream.close();
        }catch (Exception e){
            System.out.println("Failed to load the properties");
            e.printStackTrace();
        }
    }
    public static String getProperties(String key){
        return configFile.getProperty(key);
    }
}
