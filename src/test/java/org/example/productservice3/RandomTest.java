package org.example.productservice3;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomTest {

//    public static void main(String a) {
//        testRandomNumber();
//    }

    @Test
    public void testRandomNumber_FlakyTest() {
        Random random = new Random();
        int n = random.nextInt(10);
        assert(n<5);
    }
}
