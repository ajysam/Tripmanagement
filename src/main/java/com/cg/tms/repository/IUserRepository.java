package com.cg.tms.repository;

import com.cg.tms.entities.User;

public interface IUserRepository {
public  User addNewUser(User user);
public User signIn(User user);
public User signOut(User user);
}
