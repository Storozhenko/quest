package com.sam.quest.command;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class GetListCommand <E> implements Command <E> {

    E list;
    Object obj;

    public GetListCommand(Object obj) {
        this.obj = obj;
    }
    @Transactional
    public E execute(HibernateTemplate hibernateTemplate) throws Exception{
        list = (E)hibernateTemplate.findByCriteria(DetachedCriteria.forClass(obj.getClass()));
        return list;
    }
}
