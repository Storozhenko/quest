package com.sam.quest.command;

import org.hibernate.Session;

public class DeleteCommand<E> implements Command <Void> {
    E obj;
    public DeleteCommand(E obj) {
        this.obj = obj;
    }
    public Void execute(Session session) throws Exception{
        session.delete(obj);
        return null;
    }
}
