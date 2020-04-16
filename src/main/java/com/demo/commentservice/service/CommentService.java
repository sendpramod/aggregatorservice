package com.demo.commentservice.service;

import com.demo.commentservice.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "feignCommentService", url = "http://localhost:8383/comments")
public interface CommentService {
    @GetMapping("/{userId}")
    public Comment findCommentById(String commentId);

    @GetMapping("/user/{userId}")
    public List<Comment> findCommentsByUserId(@PathVariable("userId") String userId);


}
