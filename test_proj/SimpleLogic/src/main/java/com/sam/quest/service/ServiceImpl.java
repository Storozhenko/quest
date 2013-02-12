package com.sam.quest.service;


import com.sam.quest.dao.hibernate.GetListCommand;
import com.sam.quest.dao.hibernate.TransactionalPerformer;
import com.sam.quest.entity.Users;

import java.util.ArrayList;
import java.util.List;


public class ServiceImpl<E> implements MultiService<E>{

    public void addRecord(E obj) {

    }
    public List<E> listRecord(E obj) {
        TransactionalPerformer fm = new TransactionalPerformer<List<Users>>();
        List <E> list  = null;
        try {
            list = (ArrayList<E>)fm.executeCommand(new GetListCommand<ArrayList, E>(new ArrayList(), obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void removeRecord(int id) {

    }
}
