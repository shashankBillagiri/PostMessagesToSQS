package com.learning.postmessagestosqs.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.QueueNameExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMessageQueue {

    @Value("${app.config.create.student.queue}")
    private String messageQueueName;

    private final AmazonSQS amazonSQSClient;




    public void createMessageQueue() {
        CreateQueueRequest request = new CreateQueueRequest();
        request.setQueueName(messageQueueName);
        try {
            CreateQueueResult queue = amazonSQSClient.createQueue(request);
            System.out.println("Queue Url is :"+queue.getQueueUrl());
        } catch (QueueNameExistsException e) {
            System.out.println("Queue Name Exists");
        }
    }
}
