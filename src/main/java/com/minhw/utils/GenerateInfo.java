package com.minhw.utils;

import com.github.javafaker.Faker;

/**
 * @author mz
 */
public class GenerateInfo {
    Faker faker = new Faker();

    public String get_name() {
        // Miss Samanta Schmidt
        String name = faker.name().fullName();
        return name;

    }

    public String get_sentence() {
        return faker.lorem().sentence(6);
    }

}
