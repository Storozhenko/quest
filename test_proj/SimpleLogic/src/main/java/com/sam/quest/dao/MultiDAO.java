package com.sam.quest.dao;


public interface MultiDAO <E> {
    public boolean insertRecord(Object obj);
    public boolean deleteRecord(Object obj);
    public E findRecord(long id, E obj);
    public boolean updateRecord(Object obj);
}
