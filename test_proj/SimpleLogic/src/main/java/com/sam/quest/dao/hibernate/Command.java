package com.sam.quest.dao.hibernate;

import org.hibernate.Session;

public interface Command {
    public void execute(Session session) throws Exception;
}
