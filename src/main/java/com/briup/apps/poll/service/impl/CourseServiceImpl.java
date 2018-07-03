package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.CourseExample;
import com.briup.apps.poll.dao.CourseMapper;
import com.briup.apps.poll.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {
@Autowired
private CourseMapper courseMapper;
	@Override
	public List<Course> findAll() throws Exception {
	CourseExample example =new CourseExample();
		// TODO Auto-generated method stub
		return courseMapper.selectByExampleWithBLOBs(example);
	}
	@Override
	public List<Course> query(String keywords) throws Exception {
		CourseExample example =new CourseExample();
		// TODO Auto-generated method stub
		example.createCriteria().andNameLike(keywords);
		return courseMapper.selectByExample(example);
	}

	@Override
	public void save(Course course) throws Exception {
		// TODO Auto-generated method stub
		courseMapper.insert(course);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		 courseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Course course) throws Exception {
		// TODO Auto-generated method stub
		courseMapper.updateByPrimaryKey(course);
	}
	
	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		for(long id:ids){
			courseMapper.deleteByPrimaryKey(id);
		}
	}
	@Override
	public void saveOrUpdate(Course course) throws Exception {
		
		
	}
	
	
}
