package com.demo.commentservice.service;

import com.demo.commentservice.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    RestTemplate restTemplate;
    @Value("${user.service.uri}")
    private String userServiceUri;

    @Override
    @HystrixCommand(fallbackMethod = "fallBackGetUserById")
    public User getUserById(String userId) {
        String uri = userServiceUri + "/" + userId;
        return restTemplate.getForObject(uri, User.class);
    }

    public User fallBackGetUserById(String userId) {
        User user = new User();
        user.setUserId(userId);
        return user;
    }
}
