package com.sam.quest.dao.jdbc;


import com.sam.quest.dao.AnswQuestionDAO;
import com.sam.quest.entity.AnswQuestions;


public class JDBCAnswQuestionDAO implements AnswQuestionDAO {

    public boolean insertAnswQuestion(AnswQuestions answQuest){
        return true;
    }
    public boolean deleteAnswQuestion(AnswQuestions answQuest){
        return true;
    }
    public AnswQuestions findAnswQuestion(long answQuestId){
        return new AnswQuestions();
    }
    public boolean updateAnswQuestion(AnswQuestions answQuest){
        return true;
    }
}
