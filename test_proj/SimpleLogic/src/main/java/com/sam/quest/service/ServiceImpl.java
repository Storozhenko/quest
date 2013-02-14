package com.sam.quest.service;


import com.sam.quest.dao.hibernate.GetListCommand;
import com.sam.quest.dao.hibernate.InsertCommand;
import com.sam.quest.dao.hibernate.TransactionalPerformer;
import com.sam.quest.entity.Users;

import java.util.ArrayList;
import java.util.List;


public class ServiceImpl<E> implements MultiService<E> {

    public void addRecord(E obj) throws Exception{
        TransactionalPerformer tp = new TransactionalPerformer<E>();
        try {
            tp.executeCommand(new InsertCommand(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<E> listRecord(E obj) throws Exception{
        TransactionalPerformer tp = new TransactionalPerformer<List<E>>();
        List <E> list  = null;
        list = (ArrayList<E>)tp.executeCommand(new GetListCommand<ArrayList, E>(new ArrayList(), obj));
        return list;
    }

    public void removeRecord(int id) throws Exception{

    }
}
