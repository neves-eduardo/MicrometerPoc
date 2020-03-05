package com.neves_eduardo.micrometer_poc;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;


@Component
public class MessageCustomMetric {
    private MeterRegistry meterRegistry;
    private AtomicInteger totalCharacterGauge;

    @Autowired
    public MessageCustomMetric(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        this.totalCharacterGauge = meterRegistry.gauge("total.characters.gauge", new AtomicInteger(0));
    }


    public void counterMessage(Message message) {
        Counter.builder("message.counter").tag("id", String.valueOf(message.getId())).register(meterRegistry).increment(1);

    }

    public void addToTotalChars(int value) {
        totalCharacterGauge.set(totalCharacterGauge.intValue() + value);
    }

}
