package com.buggy_cars_rating.utils;

import com.buggy_cars_rating.dto.UserDto;
import net.datafaker.Faker;

public class RandomUserFactory {

    private static final Faker faker = new Faker();

    public static UserDto generateRandomUser() {
        return new UserDto(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.credentials().username(),
                faker.credentials().password(10, 20, true, true, true)
        );
    }
}
