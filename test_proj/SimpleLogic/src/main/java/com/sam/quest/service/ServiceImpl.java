package com.sam.quest.service;


import com.sam.quest.dao.hibernate.*;
import java.util.ArrayList;
import java.util.List;


public class ServiceImpl<E> implements MultiService<E>{

    public void addRecord(E obj) throws Exception{
        TransactionalPerformer tp = new TransactionalPerformer<E>();
        tp.executeCommand(new InsertCommand(obj));
    }
    public List<E> listRecord(E obj) throws Exception{
        TransactionalPerformer tp = new TransactionalPerformer<List<E>>();
        List <E> list = (ArrayList<E>)tp.executeCommand(new GetListCommand<ArrayList<E>>(new ArrayList<E>(), obj));
        return list;
    }
    public E findRecord(long id, E obj) throws Exception{
        TransactionalPerformer tp = new TransactionalPerformer<E>();
        obj = (E)tp.executeCommand(new FindCommand(id, obj));
        return obj;
    }
    public void deleteRecord(E obj) throws Exception{
        TransactionalPerformer tp = new TransactionalPerformer<E>();
        tp.executeCommand(new DeleteCommand(obj));
    }
    public void updateRecord(E obj) throws Exception{
        TransactionalPerformer tp = new TransactionalPerformer<E>();
        tp.executeCommand(new UpdateCommand(obj));
    }
}
