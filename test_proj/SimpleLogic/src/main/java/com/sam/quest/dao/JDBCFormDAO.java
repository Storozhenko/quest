package com.sam.quest.dao;


import com.sam.quest.dao.factory.JDBCDAOFactory;
import com.sam.quest.entity.Forms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class JDBCFormDAO implements FormDAO {

    private boolean res;
    private Statement stmt;
    private ResultSet rs;
    private Connection con;
    private PreparedStatement prepStmt = null;

    public boolean insertForm(Forms form){
        try {
            res = true;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            con = JDBCDAOFactory.createConnection();
            prepStmt = con.prepareStatement("insert into forms_db.forms values (default, ?, ?, ?);");
            prepStmt.setString(1, form.getFormName());
            prepStmt.setString(2, String.valueOf(form.getUserId().getUserId()));
            prepStmt.setString(3, dateFormat.format(form.getFormDate()));
            prepStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JDBCDAOFactory.closeConnection();
        }
        return res;
    }

    public boolean deleteForm(Forms form){
        try {
            res = true;
            con = JDBCDAOFactory.createConnection();
            prepStmt = con.prepareStatement("delete from forms_db.forms where form_name=? ;");
            prepStmt.setString(1, form.getFormName());
            prepStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JDBCDAOFactory.closeConnection();
        }
        return res;
    }

    public Forms findForm(long formId){
        return new Forms();
        //stub
    }

    public boolean updateForm(Forms form){
        try {
            res = true;
            con = JDBCDAOFactory.createConnection();
            prepStmt = con.prepareStatement("update forms_db.forms set form_name=?, user_id=?, form_date=? " +
                    "where form_id=?;");
            prepStmt.setString(4, String.valueOf(form.getFormId()));
            prepStmt.setString(1, form.getFormName());
            prepStmt.setString(2, String.valueOf(form.getUserId().getUserId()));
            prepStmt.setString(3, String.valueOf(form.getFormDate()));
            prepStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JDBCDAOFactory.closeConnection();
        }
        return res;
    }
}
