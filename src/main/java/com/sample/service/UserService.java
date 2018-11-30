package com.sample.service;

import com.sample.generic.GenericService;
import com.sample.model.User;

public interface UserService extends GenericService<User> {

    User findUserById(long id);
}
