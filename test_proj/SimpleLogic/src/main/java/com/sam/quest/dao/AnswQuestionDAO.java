package com.sam.quest.dao;

import com.sam.quest.entity.AnswQuestions;

public interface AnswQuestionDAO {
    public boolean insertAnswQuestion(AnswQuestions answQuest);
    public boolean deleteAnswQuestion(AnswQuestions answQuest);
    public AnswQuestions findAnswQuestion(long answQuestId);
    public boolean updateAnswQuestion(AnswQuestions answQuest);
}
