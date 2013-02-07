package com.sam.quest.dao.jdbc;


import com.sam.quest.dao.*;
import com.sam.quest.entity.AnswForms;


public class JDBCAnswFormDAO implements AnswFormDAO {

    public boolean insertAnswForm(AnswForms answForm){
        return true;
    }
    public boolean deleteAnswForm(AnswForms answForm){
        return true;
    }
    public AnswForms findAnswForm(long answFormId){
        return new AnswForms();
    }
    public boolean updateAnswForm(AnswForms answForm){
        return true;
    }
}
