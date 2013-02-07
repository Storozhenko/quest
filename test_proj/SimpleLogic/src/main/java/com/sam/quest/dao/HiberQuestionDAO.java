package com.sam.quest.dao;

import com.sam.quest.entity.Users;

public class HiberQuestionDAO implements QuestionDAO {

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
