package ratelimiter;

import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.Assertions;


class DriverMainTest {

    @Test
    void main() {
        //DriverMain obj = new DriverMain();
        RateLimiter rateLimiter = new SlidingWindow(10);
        DriverMain.sendRequest(rateLimiter,100, 10);

        Assertions.assertNotNull(rateLimiter);


        Assertions.assertTrue(9 <= rateLimiter.maxRequestPerSec);




    }
}