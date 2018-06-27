package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.GradeExample;
import com.briup.apps.poll.dao.GradeMapper;
import com.briup.apps.poll.service.IGradeService;

@Service
public class GradeServicelImpl implements IGradeService{
	@Autowired
	private GradeMapper gradeMapper;
	@Override
	public List<Grade>findAll()throws Exception{
		GradeExample example=new GradeExample();
		return gradeMapper.selectByExampleWithBLOBs(example);
	}
	@Override
	public List<Grade> query(String keywords) throws Exception {
		GradeExample example =new GradeExample();
		// TODO Auto-generated method stub
		example.createCriteria().andNameLike(keywords);
		return gradeMapper.selectByExample(example);
	}

	@Override
	public void save(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		 gradeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		gradeMapper.updateByPrimaryKey(grade);
	}
	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		for(long id:ids){
			gradeMapper.deleteByPrimaryKey(id);
		}
	}
}
