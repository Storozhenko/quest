package com.sam.quest.dao;

import com.sam.quest.entity.Forms;

public interface FormDAO {
    public boolean insertForm(Forms form);
    public boolean deleteForm(Forms form);
    public Forms findForm(long formId);
    public boolean updateForm(Forms form);
}
