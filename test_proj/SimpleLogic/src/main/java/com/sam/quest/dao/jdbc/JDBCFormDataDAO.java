package com.sam.quest.dao.jdbc;


import com.sam.quest.dao.FormDataDAO;
import com.sam.quest.entity.FormsData;


public class JDBCFormDataDAO implements FormDataDAO {

    public boolean insertFormData(FormsData formData){
        return true;
    }
    public boolean deleteFormData(FormsData formData){
        return true;
    }
    public FormsData findFormData(long formDataId){
        return new FormsData();
    }
    public boolean updateFormData(FormsData formData){
        return true;
    }
}
