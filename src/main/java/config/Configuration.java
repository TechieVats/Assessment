package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    public Properties prop;
    private static final String CONFIG_PATH="//src//main//java//config//Environment.properties";

    public Properties getProperties() {
        prop = new Properties();

        try {
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + CONFIG_PATH);
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

public String getCustomProperty( String propertyName)
    {
        prop = new Properties();

        try {
            FileInputStream ip = new FileInputStream( System.getProperty("user.dir") + CONFIG_PATH);
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(propertyName);
    }
}