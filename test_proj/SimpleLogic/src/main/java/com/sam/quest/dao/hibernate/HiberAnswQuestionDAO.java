package com.sam.quest.dao.hibernate;

import com.sam.quest.dao.AnswQuestionDAO;
import com.sam.quest.entity.AnswQuestions;

public class HiberAnswQuestionDAO implements AnswQuestionDAO {

    public boolean insertAnswQuestion(AnswQuestions answForm){
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
