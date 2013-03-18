package com.sam.quest.command;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class GetListHQLCommand<E> implements Command <E> {
    String hqlQuery;
    E list;
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public GetListHQLCommand(String hqlQuery) {
        this.hqlQuery = hqlQuery;
    }
    @Transactional
    public E execute(HibernateTemplate hibernateTemplate) throws Exception{
        list = (E)hibernateTemplate.find(hqlQuery);
        return list;
    }
}
