package com.sam.quest.command;

import org.springframework.orm.hibernate3.HibernateTemplate;

public interface Command <E> {
    public E execute(HibernateTemplate hibernateTemplate) throws Exception;
}
