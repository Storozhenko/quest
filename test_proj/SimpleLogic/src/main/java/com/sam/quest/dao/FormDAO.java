package com.sam.quest.dao;

import com.sam.quest.entity.Forms;

public interface FormDAO {
    public boolean insertForm(Forms form);
    public boolean deleteForm(Forms form);
    public Forms findUser(int formId);
    public boolean updateUser(Forms form);
}
