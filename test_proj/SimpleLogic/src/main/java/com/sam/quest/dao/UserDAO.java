package com.sam.quest.dao;

import  com.sam.quest.entity.Users;

public interface UserDAO {
    public boolean insertUser(Users user);
    public boolean deleteUser(Users user);
    public Users findUser(int user_id);
    public boolean updateUser(Users user);
}
