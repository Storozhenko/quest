package com.sam.quest.command;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class DeleteHQLCommand<E> implements Command <Void> {
    String hqlQuery;
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public DeleteHQLCommand(String hqlQuery) {
        this.hqlQuery = hqlQuery;
    }

    @Transactional
    public Void execute(HibernateTemplate hibernateTemplate) throws Exception{
        hibernateTemplate.execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hqlQuery);
                return query.executeUpdate();
            }
        });
        return null;
    }
}
