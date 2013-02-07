package com.sam.quest.dao;

import com.sam.quest.entity.Questions;

public interface QuestionDAO {
    public boolean insertQuestion(Questions quest);
    public boolean deleteQuestion(Questions quest);
    public Questions findQuestion(long questionId);
    public boolean updateQuestion(Questions quest);
}
