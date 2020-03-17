package hu.lock.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomKeyGenerator {

    private static final Random random = new Random();

    public static String generateKey(int length) {
        String generatedKey = "";
        List<Integer> numbers = new ArrayList<>(numbers());
        for(int i = 0 ; i < length; i++) {
            int num = random.nextInt(numbers.size());
            generatedKey += numbers.get(num);
            numbers.remove(num);
        }
        return generatedKey;
    }

    private static List<Integer> numbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
