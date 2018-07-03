package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Qq;
import com.briup.apps.poll.bean.QqExample;
import com.briup.apps.poll.bean.extend.QqVM;
import com.briup.apps.poll.dao.QqMapper;
import com.briup.apps.poll.service.IQqService;
@Service
public class QqServiceImpl implements IQqService{
@Autowired
private QqMapper qqMapper;
@Autowired
private QqMapper qqVMMapper;
	@Override
	public List<Qq> findAll() throws Exception {
		QqExample example=new QqExample();
		// TODO Auto-generated method stub
		return qqMapper.selectByExample(example);
	}

	@Override
	public List<QqVM> findAllQqVM() throws Exception {
		// TODO Auto-generated method stub
		return qqVMMapper.selectAll();
	}

	@Override
	public void save(Qq qq) throws Exception {
		// TODO Auto-generated method stub
		qqMapper.insert(qq);
	}

	@Override
	public void update(Qq qq) throws Exception {
		// TODO Auto-generated method stub
		qqMapper.updateByPrimaryKey(qq);
	}

}
