package com.neves_eduardo.micrometer_poc;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class MicrometerPocApplication {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(MicrometerPocApplication.class, args);
        MessageCustomMetric messageCustomMetric = new MessageCustomMetric((MeterRegistry) ac.getBean("meterRegistry"));
        messageCustomMetric.CounterMessage(new Message(1,"afkaeiojfiega"));
        messageCustomMetric.CounterMessage(new Message(2,"afkaeiojfiega"));
        messageCustomMetric.CounterMessage(new Message(3,"afkaeiojfiega"));
        MeterRegistry meterRegistry = (MeterRegistry) ac.getBean("meterRegistry");
        System.out.println(meterRegistry.find("Messages").counters());
    }

}
