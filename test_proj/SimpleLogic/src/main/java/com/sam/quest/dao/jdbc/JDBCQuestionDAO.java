package com.sam.quest.dao.jdbc;

import com.sam.quest.dao.QuestionDAO;
import com.sam.quest.entity.Questions;

public class JDBCQuestionDAO implements QuestionDAO {

    public boolean insertQuestion(Questions quest){
        return true;
    }
    public boolean deleteQuestion(Questions quest){
        return true;
    }
    public Questions findQuestion(long questId){
        return new Questions();
    }
    public boolean updateQuestion(Questions quest){
        return true;
    }
}
