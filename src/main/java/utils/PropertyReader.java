package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public static String getEnvironment(String key) {
        Properties properties = new Properties();
        try {
            FileReader fileReader = new FileReader("src/main/resources/environment.properties");
            properties.load(fileReader);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
