package com.cg.tms.service;

import com.cg.tms.entities.User;

public interface IUserService {
public  User addNewUser(User user);
public User signIn(User user);
public User signOut(User user);
}
