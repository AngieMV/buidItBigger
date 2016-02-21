package com.udacity.gradle.builditbigger.jokes;

import org.junit.Assert;
import org.junit.Test;

public class ProviderTest {

    @Test
    public void testTechProvider() {
        Provider provider = new TechProvider();
        String joke = provider.getJoke();

        Assert.assertNotNull(joke);
    }

}