package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomEmailGenerator {

    public static String generateRandomEmail() {
        String randomPrefix = RandomStringUtils.randomAlphabetic(7);
        String randomDomain = RandomStringUtils.randomAlphabetic(5);
        return randomPrefix + "@" + randomDomain + ".com";
    }
}
