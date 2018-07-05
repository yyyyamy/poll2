package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;

public interface ISurveyService {
void saveOrUpdateSurvey(Survey survey)throws Exception;
List<SurveyVM>findAll()throws Exception;
SurveyVM findById(long id)throws Exception;
//查找课调单表
Survey findSurveyById(long id)throws Exception;
List<SurveyVM> findByStatus(String status)throws Exception;
}
 