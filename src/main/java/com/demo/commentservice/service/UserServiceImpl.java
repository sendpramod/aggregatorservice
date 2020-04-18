package com.demo.commentservice.service;

import com.demo.commentservice.model.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;

    private String getInstanceUrl() {
        Application application =
                eurekaClient.getApplication("userservice");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        return  instanceInfo.getHomePageUrl();
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallBackGetUserById")
    public User getUserById(String userId) {
        String uri = getInstanceUrl() + "users/" + userId;
        return restTemplate.getForObject(uri, User.class);
    }

    public User fallBackGetUserById(String userId) {
        User user = new User();
        user.setUserId(userId);
        return user;
    }
}
