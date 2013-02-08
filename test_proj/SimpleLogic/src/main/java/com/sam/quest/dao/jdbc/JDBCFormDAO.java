package com.sam.quest.dao.jdbc;

import com.sam.quest.dao.*;
import com.sam.quest.dao.factory.JDBCDAOUserFactory;
import com.sam.quest.entity.Forms;
import com.sam.quest.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class JDBCFormDAO<E> implements MultiDAO<E> {

    private boolean res;
    private Statement stmt;
    private ResultSet rs;
    private Connection con;
    private PreparedStatement prepStmt = null;

    public boolean insertRecord(E obj){
        try {
            res = true;
            Forms form = (Forms)obj;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            con = JDBCDAOUserFactory.createConnection();
            prepStmt = con.prepareStatement("insert into forms_db.forms values (default, ?, ?, ?);");
            prepStmt.setString(1, form.getFormName());
            prepStmt.setString(2, String.valueOf(form.getUserId().getUserId()));
            prepStmt.setString(3, dateFormat.format(form.getFormDate()));
            prepStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JDBCDAOUserFactory.closeConnection();
        }
        return res;
    }

    public boolean deleteRecord(E obj){
        try {
            res = true;
            Forms form = (Forms)obj;
            con = JDBCDAOUserFactory.createConnection();
            prepStmt = con.prepareStatement("delete from forms_db.forms where form_name=? ;");
            prepStmt.setString(1, form.getFormName());
            prepStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JDBCDAOUserFactory.closeConnection();
        }
        return res;
    }

    public E findRecord(long formId, E obj){
        Forms form = (Forms)obj;
        Users user = new Users();
        try {
            res = true;
            con = JDBCDAOUserFactory.createConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from forms_db.forms where form_id=" + String.valueOf(formId) + ";");
            while (rs.next()) {
                form.setFormId(rs.getLong("form_id"));
                form.setFormName(rs.getString("form_name"));
                user.setUserId(rs.getLong("user_id"));
                form.setUserId(user);
                form.setFormDate(rs.getDate("form_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JDBCDAOUserFactory.closeConnection();
        }
        return (E)form;
    }

    public boolean updateRecord(E obj){
        try {
            res = true;
            Forms form = (Forms)obj;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            con = JDBCDAOUserFactory.createConnection();
            prepStmt = con.prepareStatement("update forms_db.forms set form_name=?, user_id=?, form_date=? " +
                    "where form_id=?;");
            prepStmt.setString(4, String.valueOf(form.getFormId()));
            prepStmt.setString(1, form.getFormName());
            prepStmt.setString(2, String.valueOf(form.getUserId().getUserId()));
            prepStmt.setString(3, dateFormat.format(form.getFormDate()));
            prepStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            JDBCDAOUserFactory.closeConnection();
        }
        return res;
    }
}
