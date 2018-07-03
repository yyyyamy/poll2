package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.AnswersExample;
import com.briup.apps.poll.dao.AnswersMapper;

import com.briup.apps.poll.service.IAnswersService;

@Service
public class AnswersServiceImpl implements IAnswersService{
@Autowired
private AnswersMapper answersMapper;
	@Override
	public List<Answers> findAll() throws Exception {
	AnswersExample example=new AnswersExample();
	
	// TODO Auto-generated method stub
		return answersMapper.selectByExample(example);
	}

	@Override
	public List<Answers> query(String keywords) throws Exception {
		AnswersExample example=new AnswersExample();
	example.createCriteria().andCheckesLike(keywords);
		// TODO Auto-generated method stub
		return answersMapper.selectByExample(example);
	}

	@Override
	public void save(Answers answers) throws Exception {
		// TODO Auto-generated method stub
		
		 answersMapper.insert(answers);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		answersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Answers answers) throws Exception {
		// TODO Auto-generated method stub
		answersMapper.updateByPrimaryKey(answers);
	}

	@Override
	public void batchDelete(Long[] ids) throws Exception {
		// TODO Auto-generated method stub
		for(Long id:ids){
			answersMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public void saveOrUpdate(Answers answers) throws Exception {
		if(answers.getId()==null){
			answersMapper.updateByPrimaryKey(answers);
		}else{
			answersMapper.insert(answers);
			
		}
	}

	@Override
	public List<Answers> findAnswersBySurveyId(Long surveyId) throws Exception {
		AnswersExample example=new AnswersExample();
		example.createCriteria().andSurveyIdEqualTo(surveyId);
		return answersMapper.selectByExample(example);
	}
}
