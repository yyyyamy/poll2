package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.service.IOptionsService;

@Service
public class OptionsServiceImpl implements IOptionsService {
	@Autowired
	private OptionsMapper optionsMapper;

	@Override
	public List<Options> findAll() throws Exception {
		OptionsExample example = new OptionsExample();
		return optionsMapper.selectByExampleWithBLOBs(example);

	}

	@Override
	public List<Options> query(String keywords) throws Exception {
		OptionsExample example = new OptionsExample();
		example.createCriteria().andLabelLike(keywords);
		return optionsMapper.selectByExample(example);
	}

	@Override
	public void save(Options options) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		optionsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Options options) throws Exception {
		// TODO Auto-generated method stub
		optionsMapper.updateByPrimaryKey(options);
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		for (long id : ids) {
			optionsMapper.deleteByPrimaryKey(id);
		}
	}
}
