package com.sam.quest.dao;

import com.sam.quest.entity.Forms;

public class HiberFormDAO implements FormDAO {

    public boolean insertForm(Forms form){
        return true;
    }
    public boolean deleteForm(Forms form){
        return true;
    }
    public Forms findForm(long FormId){
        return new Forms();
    }
    public boolean updateForm(Forms form){
        return true;
    }

}
