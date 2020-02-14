package com.neves_eduardo.micrometer_poc;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class MicrometerPocApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ac = SpringApplication.run(MicrometerPocApplication.class, args);
        MeterRegistry meterRegistry = ((MeterRegistry) ac.getBean("meterRegistry"));
        while(true){
            System.out.println("Message Counters Meters: " + meterRegistry.find("message.counter").counters().size());
            System.out.println("Total Number of Characters of all messages Gauge :" + meterRegistry.find("total.characters.gauge").gauge().value());
            Thread.sleep(10000);
        }
    }

}
