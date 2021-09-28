package utils;

import java.util.Base64;
import java.util.Random;
import java.util.SplittableRandom;

public class Util {

    /**
     * Преобразовать строку в base64
     */

    public static String convertStringToBase64(String string) {
        return Base64.getEncoder().encodeToString(string.getBytes());
    }


    /**
     * Сгенерировать случайное значение из 6 символов
     */
    public static String generateRandomValue() {

        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder(3);
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();

        return new SplittableRandom().nextInt(100, 999) + output;
    }


}
