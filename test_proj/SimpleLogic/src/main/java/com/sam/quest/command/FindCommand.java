package com.sam.quest.command;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class FindCommand<E> implements Command <E> {
    E obj;
    long id;
    String hqlQuery;

    public FindCommand(String hqlQuery) {
        this.obj = obj;
        this.id = id;
        this.hqlQuery = hqlQuery;
    }

    public E execute(HibernateTemplate hibernateTemplate) throws Exception{
        //Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        //obj = (E)session.get(obj.getClass(), id);
        obj = (E)hibernateTemplate.find(hqlQuery);
        return obj;
    }
}
