package com.sam.quest.command;

import org.springframework.orm.hibernate3.HibernateTemplate;

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

    public E execute(HibernateTemplate hibernateTemplate) throws Exception{
        switch (type) {
            case 1:
                obj = (E)hibernateTemplate.find(hqlQuery);
                break;
            case 2:
                obj = (E)hibernateTemplate.get(obj.getClass().getName(), id);
                break;
        }
        return obj;
    }
}
