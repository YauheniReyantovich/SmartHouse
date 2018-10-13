package com.sample.controller;

import com.sample.generic.GenericWebService;
import com.sample.model.User;
import com.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserWebService extends GenericWebService<User> {

    @Autowired
    public UserWebService(UserService service) {
        super(service);
    }

}
