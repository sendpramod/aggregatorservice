package com.demo.commentservice.service;

import com.demo.commentservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {
    public User getUserById(String userId);
}


