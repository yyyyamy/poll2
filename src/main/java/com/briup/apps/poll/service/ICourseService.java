package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Course;

public interface ICourseService {
List<Course>findAll() throws Exception;
List<Course>query(String keywords)throws Exception;
void save (Course course)throws Exception;
void deleteById(long id)throws Exception;
void update(Course course)throws Exception;
void batchDelete(List<Long> ids) throws Exception; 
void saveOrUpdate(Course course)throws Exception;
}
