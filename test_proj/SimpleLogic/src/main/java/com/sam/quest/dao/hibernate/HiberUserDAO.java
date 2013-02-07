package com.sam.quest.dao.hibernate;

import com.sam.quest.dao.factory.HiberDAOFactory;
import com.sam.quest.dao.UserDAO;
import com.sam.quest.entity.Users;
import org.hibernate.*;

public class HiberUserDAO implements UserDAO {

    private boolean res;
    private Transaction tr;
    private Session session;

    public boolean insertUser(Users user){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.save(user);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
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
