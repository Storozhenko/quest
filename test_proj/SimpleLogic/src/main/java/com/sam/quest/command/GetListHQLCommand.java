package com.sam.quest.command;

import org.hibernate.Query;
import org.hibernate.Session;

public class GetListHQLCommand<E> implements Command <E> {

    String hqlQuery;
    E list;

    public GetListHQLCommand(String hqlQuery) {
        this.hqlQuery = hqlQuery;
    }

    public E execute(Session session) throws Exception{
        Query query = session.createQuery(hqlQuery);
        list = (E)query.list();
        return list;
    }
}
