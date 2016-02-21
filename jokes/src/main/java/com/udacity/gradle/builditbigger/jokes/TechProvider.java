package com.udacity.gradle.builditbigger.jokes;

import java.util.Random;

public class TechProvider implements Provider {

    private static final int MAX_NUMBER_JOKES = TechBank.JOKES.length;

    private Random random = new Random();

    @Override
    public String getJoke() {
        int i = random.nextInt(MAX_NUMBER_JOKES);
        return TechBank.JOKES[i];
    }

}
