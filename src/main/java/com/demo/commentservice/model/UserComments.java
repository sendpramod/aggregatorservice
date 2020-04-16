package com.demo.commentservice.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserComments {
    private User user;
    private List<Comment> comments;
}
