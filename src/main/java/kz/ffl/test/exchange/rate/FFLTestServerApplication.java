package kz.ffl.test.exchange.rate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FFLTestServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FFLTestServerApplication.class, args);
    }

}

