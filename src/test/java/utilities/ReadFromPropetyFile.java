package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropetyFile {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("/Users/kshitiztyagi/Desktop/TestAutomationFramework/src/test/resources/configfiles/config.properties");
        Properties p = new Properties() ;
        p.load(fr);
        System.out.println(p.getProperty("browser"));
    }
}
