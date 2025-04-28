package com.yesmadam.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = utils.ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
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