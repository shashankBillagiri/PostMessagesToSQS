package com.learning.postmessagestosqs.configuration;

import com.learning.postmessagestosqs.service.CreateMessageQueue;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SQSConfiguration {


    private final CreateMessageQueue createMessageQueue;

    @PostConstruct
    public void initializeMessageQueue() {
        createMessageQueue.createMessageQueue();
    }
}
