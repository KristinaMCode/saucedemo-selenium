package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found");
            }
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties", e);
        }
    }

    public static String get(String key) {
        String value = props.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Missing key in config.properties: " + key);
        }
        return value;
    }

    public static String getPassword() {
        String password = System.getenv("SAUCE_PASSWORD");
        if (password == null) {
            throw new RuntimeException("Environment variable SAUCE_PASSWORD is not set");
        }
        return password;
    }
}