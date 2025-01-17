package com.ductn.VinaVita;

import com.twilio.Twilio;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VinaVitaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VinaVitaApplication.class, args);

        System.out.println("OpenJDK Version: " + System.getProperty("java.version"));
        System.out.println("Twilio SDK Version: " + Twilio.VERSION);
        System.out.println("RUN COMPLETED AT: " + new Date());
        System.out.println("OK Ngok Duk");
    }
}
