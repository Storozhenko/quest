package com.sam.quest.command;

import org.hibernate.Session;

public interface Command <E> {
    public E execute(Session session) throws Exception;
}
