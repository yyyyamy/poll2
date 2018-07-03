package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.ClazzExample;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.dao.ClazzMapper;
import com.briup.apps.poll.dao.extend.ClazzVMMapper;
import com.briup.apps.poll.service.IClazzService;
@Service
public class ClazzServiceImpl  implements IClazzService{
	@Autowired
	private ClazzMapper clazzMapper;
	@Autowired
	private ClazzVMMapper clazzVMMapper;
	@Override
	public List<Clazz> findAll() throws Exception {
		ClazzExample example =new ClazzExample();
		// TODO Auto-generated method stub
		return clazzMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<Clazz> query(String keywords) throws Exception {
		ClazzExample example =new ClazzExample();
		example.createCriteria().andNameLike(keywords);
		// TODO Auto-generated method stub
		return clazzMapper.selectByExample(example);
	}

	@Override
	public void save(Clazz clazz) throws Exception {
		// TODO Auto-generated method stub
		
		clazzMapper.insert(clazz);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		clazzMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void update(Clazz clazz) throws Exception {
		// TODO Auto-generated method stub
		clazzMapper.updateByPrimaryKey(clazz);
		
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		for(long id:ids){
			clazzMapper.deleteByPrimaryKey(id);
		}
		
	}

	

	@Override
	public List<ClazzVM> findAllClazzVM() throws Exception {
		// TODO Auto-generated method stub
		return clazzVMMapper.selectAll();
	}

}
