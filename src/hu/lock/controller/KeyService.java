package hu.lock.controller;

import hu.lock.model.domain.Key;
import hu.lock.model.service.RandomKeyGenerator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class KeyService {

    private final List<Key> keys;

    public KeyService(List<Key> keys) {
        this.keys = keys;
    }

    public String getEqualKeyIds(String pattern) {
        return keys.stream()
                .filter(i -> i.isEqual(pattern))
                .map(Key::getId)
                .map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    public String getSameDigitKeyId() {
        return getOptionalSameDigitKeyId()
                .map(Object::toString)
                .orElse("nem volt ismétlődő számjegy");
    }

    private Optional<Integer> getOptionalSameDigitKeyId() {
        return keys.stream()
                .filter(i -> i.hasSameDigit())
                .map(i -> i.getId())
                .findFirst();
    }

    public String getGeneratedKey(String pattern) {
        int length = pattern.length();
        return String.format("Egy %d hosszú kódszám: %s", length, RandomKeyGenerator.generateKey(length));
    }
}
