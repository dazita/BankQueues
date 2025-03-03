package config;

import java.io.*;
import java.util.HashMap;

public class SettingsConfig {

    public HashMap<String, Integer> loadNames(String filePath) {

        try {
            HashMap<String, Integer> nameMap = new HashMap<>();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            int category = 1;
            String line;

            while ((line = reader.readLine()) != null) {
                nameMap.put(line.trim(), category);
                category++;
            }

            reader.close();
            return nameMap;
        } catch (Exception e) {
            System.err.println("File Not Found");
            return null;
        }
    }

}
