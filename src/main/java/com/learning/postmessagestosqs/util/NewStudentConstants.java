package com.learning.postmessagestosqs.util;

import java.util.Arrays;
import java.util.List;

public final class NewStudentConstants {

    public static final String REQUEST_MAPPING = "/v1/mis";

    public static final List<String> VALID_COURSES = Arrays.asList("ECE", "CSE", "EEE", "CIVIL", "MECH");


    public static final String INVALID_COURSE = "Course should be either of ECE OR CSE OR EEE OR CIVIL OR MECH";

}
