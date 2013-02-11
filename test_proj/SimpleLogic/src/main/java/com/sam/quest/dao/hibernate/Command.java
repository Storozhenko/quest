package com.sam.quest.dao.hibernate;

import org.hibernate.Session;

public interface Command <E> {
    public E execute(Session session) throws Exception;
}
