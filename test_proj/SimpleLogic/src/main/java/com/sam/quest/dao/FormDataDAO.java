package com.sam.quest.dao;

import com.sam.quest.entity.FormsData;

public interface FormDataDAO {
    public boolean insertFormData(FormsData formData);
    public boolean deleteFormData(FormsData formData);
    public FormsData findFormData(long formDataId);
    public boolean updateFormData(FormsData formData);
}
