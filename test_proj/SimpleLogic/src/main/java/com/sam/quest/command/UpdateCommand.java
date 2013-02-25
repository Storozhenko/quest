package com.sam.quest.command;

import org.hibernate.Session;

public class UpdateCommand<E> implements Command <Void> {
    E obj;
    public UpdateCommand(E obj) {
        this.obj = obj;
    }
    public Void execute(Session session) throws Exception{
        session.update(obj);
        return null;
    }
}
