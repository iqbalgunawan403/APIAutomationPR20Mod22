package helper;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.util.Random;

public class Utility {

    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/helper/JSONSchemaData/" + JSONFile);
    }

    public static String generateRandomEmail() {
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10);
        email = temp + "@testdata.com";
        return email;
    }

    public static String generateRandomUserId() {
        StringBuilder userIdBuilder = new StringBuilder();
        Random random = new Random();

        while (userIdBuilder.length() < 7) {
            int randomDigit = random.nextInt(5) + 1;
            userIdBuilder.append(randomDigit);
        }

        return userIdBuilder.toString();
    }
}
