package com.learning.postmessagestosqs.controller;

import com.learning.postmessagestosqs.dto.NewStudentRequest;
import com.learning.postmessagestosqs.exception.BadRequestException;
import com.learning.postmessagestosqs.service.StudentDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.learning.postmessagestosqs.util.NewStudentConstants.*;

@Validated
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(REQUEST_MAPPING)
public class CreateNewStudentController {


    private final StudentDetailsService studentDetailsService;



    @PostMapping(value = "/newstudents")
    public ResponseEntity<?> createNewStudents(@RequestBody List<NewStudentRequest> newStudents) throws Exception {

        for (NewStudentRequest newStudent : newStudents) {


            if (!VALID_COURSES.contains(newStudent.getCourse().toUpperCase())) {

                throw new BadRequestException(INVALID_COURSE);
            }

        }

       studentDetailsService.sendMessageToSQS(newStudents);

        return ResponseEntity.accepted().body(null);

    }
}
