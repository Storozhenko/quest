package com.sam.quest.command;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class UpdateCommand<E> implements Command <Void> {
    E obj;
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public UpdateCommand(E obj) {
        this.obj = obj;
    }

    @Transactional
    public Void execute(HibernateTemplate hibernateTemplate) throws Exception{
        hibernateTemplate.update(obj);
        return null;
    }
}
