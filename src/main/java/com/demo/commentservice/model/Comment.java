package com.demo.commentservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Comment {
    private String commentId;
    private String comment;
    private String userId;
    private List<String> mediaLinks;
    private Float rating;
    private String status;
    private String createdBy;
    private String updateBy;
}
