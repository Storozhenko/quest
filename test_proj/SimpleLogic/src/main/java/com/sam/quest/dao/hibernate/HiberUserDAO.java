package com.sam.quest.dao.hibernate;

import com.sam.quest.dao.UserDAO;
import com.sam.quest.entity.Users;

public class HiberUserDAO implements UserDAO {

    public boolean insertUser(Users user){
        return true;
    }
    public boolean deleteUser(Users user){
        return true;
    }
    public Users findUser(long userId){
        return new Users();
    }
    public boolean updateUser(Users user){
        return true;
    }

}
