package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private final String propertyFilePath = "configs/configuration.properties";

    private Properties properties;

    public ConfigFileReader() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();

            try (reader) {
                properties.load(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getSysPropertyName() {
        String sysPropertyName = properties.getProperty("sysPropertyName");

        if (sysPropertyName != null) {
            return sysPropertyName;
        } else {
            throw new RuntimeException("sysPropertyName not specified in the configuration.properties file");
        }
    }

    public String getSysPropertyValue() {
        String sysPropertyValue = properties.getProperty("sysPropertyValue");

        if (sysPropertyValue != null) {
            return sysPropertyValue;
        } else {
            throw new RuntimeException("sysPropertyValue not specified in the configuration.properties file");
        }
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");

        if (implicitlyWait != null) {
            return Long.parseLong(implicitlyWait);
        } else {
            throw new RuntimeException("implicitlyWait not specified in the configuration.properties file");
        }
    }

    public String getLogInUrl() {
        String url = properties.getProperty("logInUrl");

        if (url != null) {
            return url;
        } else {
            throw new RuntimeException("url not specified in the configuration.properties file");
        }
    }

    public String getMainUrl() {
        String main = properties.getProperty("mainUrl");

        if (main != null) {
            return main;
        } else {
            throw new RuntimeException("url not specified in the configuration.properties file");
        }
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");

        if (browser != null) {
            return browser;
        } else {
            throw new RuntimeException("browser not specified in the configuration.properties file");
        }
    }
}
