package com.sam.quest.command;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class GetListHQLCommand<E> implements Command <E> {

    String hqlQuery;
    E list;

    public GetListHQLCommand(String hqlQuery) {
        this.hqlQuery = hqlQuery;
    }

    public E execute(HibernateTemplate hibernateTemplate) throws Exception{
        list = (E)hibernateTemplate.find(hqlQuery);
        return list;
    }
}
