package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Answers;

public interface IAnswersService {
List<Answers>findAll()throws Exception;
List<Answers>query(String keywords)throws Exception;
void save (Answers answers)throws Exception;
void deleteById(long id)throws Exception;
void update (Answers answers)throws Exception;
void batchDelete(Long[] ids)throws Exception;
void saveOrUpdate(Answers answers)throws Exception;
//通过课调id查询属于该课调的所有答卷

List<Answers> findAnswersBySurveyId(Long surveyId) throws Exception;
}
