package com.sam.quest.dao;


public interface MultiDAO <E> {
    public boolean insertRecord(E obj);
    public boolean deleteRecord(E obj);
    public E findRecord(long id, E obj);
    public boolean updateRecord(E obj);
}
