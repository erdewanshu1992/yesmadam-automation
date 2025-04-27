package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream == null) {
                throw new RuntimeException("config.properties file not found in classpath!");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to load config.properties", e);
        }
    }

    private ConfigReader() {
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}


















//package utils;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//public class ConfigReader {
//
//    private static Properties properties = new Properties();
//    private final String propertyFilePath = "config.properties";  // Path to your properties file
//
//    public ConfigReader() {
//        properties = new Properties();
//        try {
//            // Load the properties file
//            FileInputStream fileInputStream = new FileInputStream(propertyFilePath);
//            properties.load(fileInputStream);
//            fileInputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Configuration file not found or unable to load.");
//        }
//    }
//
//    // Method to read values from the properties file
//    public static String getProperty(String key) {
//        return properties.getProperty(key);
//    }
//
//    // Example: Get browser type for WebDriver
//    public String getBrowser() {
//        return getProperty("browser");
//    }
//
//    // Example: Get base URL
//    public String getBaseUrl() {
//        return getProperty("baseUrl");
//    }
//}
