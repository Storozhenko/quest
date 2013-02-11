package com.sam.quest.service;

import java.util.List;

public interface MultiService <E> {
    public void addRecord(E obj);
    public List<E> listRecord(E obj);
    public void removeRecord(int id);
}
