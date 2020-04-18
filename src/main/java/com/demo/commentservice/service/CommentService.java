package com.demo.commentservice.service;

import com.demo.commentservice.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient( "commentservice")
public interface CommentService {
    @GetMapping("/{userId}")
    public Comment findCommentById(String commentId);

    @RequestMapping(value = "/comments/user/{userId}", method = RequestMethod.GET)
    public List<Comment> findCommentsByUserId(@PathVariable("userId") String userId);

}
