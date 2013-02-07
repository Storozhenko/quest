package com.sam.quest.dao.hibernate;

import com.sam.quest.dao.FormDAO;
import com.sam.quest.entity.Forms;

public class HiberFormDAO implements FormDAO {

    public boolean insertForm(Forms form){
        return true;
    }
    public boolean deleteForm(Forms form){
        return true;
    }
    public Forms findForm(long formId){
        return new Forms();
    }
    public boolean updateForm(Forms form){
        return true;
    }

}
