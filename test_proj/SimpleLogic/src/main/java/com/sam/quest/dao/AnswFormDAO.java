package com.sam.quest.dao;

import com.sam.quest.entity.AnswForms;

public interface AnswFormDAO {
    public boolean insertAnswForm(AnswForms form);
    public boolean deleteAnswForm(AnswForms form);
    public AnswForms findAnswForm(long answFormId);
    public boolean updateAnswForm(AnswForms form);
}
