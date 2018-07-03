package com.briup.apps.poll.bean.extend;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.Questionnaire;

public class QqVM {
private long id;
private Questionnaire questionnaire;
private Question question;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public Questionnaire getQuestionnaier() {
	return questionnaire;
}
public void setQuestionnaier(Questionnaire questionnaier) {
	this.questionnaire = questionnaier;
}
public Question getQuestion() {
	return question;
}
public void setQuestion(Question question) {
	this.question = question;
}
}
