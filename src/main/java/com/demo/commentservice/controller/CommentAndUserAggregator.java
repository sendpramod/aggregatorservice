package com.demo.commentservice.controller;

import com.demo.commentservice.exception.DataNotFoundException;
import com.demo.commentservice.model.Comment;
import com.demo.commentservice.model.User;
import com.demo.commentservice.model.UserComments;
import com.demo.commentservice.service.CommentService;
import com.demo.commentservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aggregator")
public class CommentAndUserAggregator {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @GetMapping("/usercomments/{userId}")
    public UserComments getUserComments(@PathVariable("userId") String userId) {
        User user = userService.getUserById(userId);
        List<Comment> comments = commentService.findCommentsByUserId(userId);
        return new UserComments(user, comments);
    }

}
