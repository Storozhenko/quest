package com.sam.quest.dao.hibernate;

import org.hibernate.Session;

public class DeleteCommand<E> implements Command {
    E obj;
    public DeleteCommand(E obj) {
        this.obj = obj;
    }
    public void execute(Session session) throws Exception{
        session.delete(obj);
    }
}
