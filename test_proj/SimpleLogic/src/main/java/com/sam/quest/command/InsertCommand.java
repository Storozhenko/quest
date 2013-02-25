package com.sam.quest.command;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class InsertCommand <E> implements Command <Void>{
    E obj;

    public InsertCommand(E obj) {
        this.obj = obj;
    }
    public Void execute(HibernateTemplate hibernateTemplate) throws Exception {
        hibernateTemplate.save(obj);
        return null;
    }
}
