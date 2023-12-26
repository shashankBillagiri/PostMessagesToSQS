package com.learning.postmessagestosqs.service;


import com.amazonaws.services.sqs.AmazonSQS;
import com.learning.postmessagestosqs.dto.NewStudentRequest;
import com.learning.postmessagestosqs.publisher.SQSMessagePublisher;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class StudentDetailsService {

    private final AmazonSQS amazonSQS;



    public void sendMessageToSQS(List<NewStudentRequest> newStudents){
        System.out.println("Sending Message to SQS");
        amazonSQS.sendMessage("https://sqs.us-east-1.amazonaws.com/524195336295/create-new-student", newStudents.toString());


    }
}
