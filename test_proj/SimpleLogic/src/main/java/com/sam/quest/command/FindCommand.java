package com.sam.quest.command;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class FindCommand<E> implements Command <E> {
    private E obj;
    private long id;
    private String hqlQuery;
    private int type;

    public FindCommand(String hqlQuery) {
        this.hqlQuery = hqlQuery;
        this.type = 1;
    }

    public FindCommand(long id, E obj) {
        this.obj = obj;
        this.id = id;
        this.type = 2;
    }
    @Transactional
    public E execute(HibernateTemplate hibernateTemplate) throws Exception{
        switch (type) {
            case 1:
                List list = hibernateTemplate.find(hqlQuery);
                obj = (E)list.get(0);
                break;
            case 2:
                obj = (E)hibernateTemplate.get(obj.getClass().getName(), id);
                break;
        }
        return obj;
    }
}
