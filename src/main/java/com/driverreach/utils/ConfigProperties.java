package com.driverreach.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Admin on 07.11.2015.
 */
public class ConfigProperties {
    private static Properties PROPERTIES;

    static {
        PROPERTIES=new Properties();
        URL props=ClassLoader.getSystemResource("Config.properties");
        try {
            PROPERTIES.load(props.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getProperty(String s) {
        return PROPERTIES.getProperty(s);
    }
}
