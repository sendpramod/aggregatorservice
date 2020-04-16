package com.demo.commentservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
public class User {
    private String userId;
    private String name;
    private String gender;
    private String emailId;
    private String mobileNo;
}
