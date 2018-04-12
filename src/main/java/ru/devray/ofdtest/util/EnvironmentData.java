package ru.devray.ofdtest.util;

import org.ini4j.Ini;

import java.io.FileReader;
import java.io.IOException;

/**
 * External data loader
 */
public class EnvironmentData {

    private static Ini properties;
    private static EnvironmentData instance;
    final static String PROPERTIES_PATH = "environment.ini";

    public EnvironmentData() {
        try {
            properties = new Ini(new FileReader("environment.ini"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EnvironmentData getInstance(){
        if (instance == null){
            instance = new EnvironmentData();
        }
        return instance;
    }

    public String loadValue(String key){
        return properties.get(key).toString();
    }
}
