package com.automation.utils;

import java.util.Random;
import java.util.UUID;

public class RandomDataGenerator {
    // Random first name
    public static String getRandomFirstName() {
        String[] names = {"John", "Jane", "Micheal", "Sara", "Daniel", "Linda", "Chris", "Paula"};
        return names[new Random().nextInt(names.length)];
    }

    // Method to generate random string with a prefix
    public static String getRandomString(String prefix, int bound) {
        return prefix + new Random().nextInt(bound);
    }

    // Random last name
    public static String getRandomLastName() {
        String[] names = {"Doe", "Smith", "Silas", "Johnson", "Samson", "Ade", "Ibrahim", "Williams"};
        return names[new Random().nextInt(names.length)];
    }

    // Random email
    public static String getRandomEmail(String domain) {
        return "user" + new Random().nextInt(10000) + "@" + domain;
    }

    // Random phone number (Nigeria-style)
    public static String getRandomPhoneNumber() {
        Random random = new Random();
        return "11" + (random.nextInt(900000000) + 100000000);
    }

    // Optional: UUID for unique ID
    public static String getRandomUUID() {
        return UUID.randomUUID().toString();
    }
}