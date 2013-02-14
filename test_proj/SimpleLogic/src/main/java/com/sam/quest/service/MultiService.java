package com.sam.quest.service;

import java.util.List;

public interface MultiService <E> {
    public void addRecord(E obj) throws Exception;
    public List<E> listRecord(E obj) throws Exception;
    public void removeRecord(E obj) throws Exception;
    public void updateRecord(E obj) throws Exception;
}
