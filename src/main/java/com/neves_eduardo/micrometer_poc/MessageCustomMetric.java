package com.neves_eduardo.micrometer_poc;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MessageCustomMetric {
    private MeterRegistry meterRegistry;
    @Autowired
    public MessageCustomMetric(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }


    public void CounterMessage(Message message) {
    Counter.builder("Messages").tag("id", String.valueOf(message.getId())).register(meterRegistry).increment(1);

    }
}
