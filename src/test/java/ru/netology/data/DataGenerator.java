package ru.netology.data;

import lombok.Value;

public class DataGenerator {

    private DataGenerator() {}

    @Value
    public static class VerificationCode {
        String code;
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardData {
        String cardNumber;
    }
}

