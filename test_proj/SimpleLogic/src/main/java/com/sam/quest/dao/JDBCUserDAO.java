package com.sam.quest.dao;


import com.sam.quest.entity.Users;

public class JDBCUserDAO implements UserDAO {
    public boolean insertUser(Users user){
        return true;
    }
    public boolean deleteUser(Users user){
        return true;
    }
    public Users findUser(int user_id){
        return new Users();
    }
    public boolean updateUser(Users user){
        return true;
    }
}
