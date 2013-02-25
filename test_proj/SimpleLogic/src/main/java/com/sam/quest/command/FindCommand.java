package com.sam.quest.command;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class FindCommand<E> implements Command <E> {
    E obj;
    long id;

    public FindCommand(long id, E obj) {
        this.obj = obj;
        this.id = id;
    }

    public E execute(HibernateTemplate hibernateTemplate) throws Exception{
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        obj = (E)session.get(obj.getClass(), id);
        return obj;
    }
}
