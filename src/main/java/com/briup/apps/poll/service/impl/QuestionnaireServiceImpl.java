package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.dao.QuestionnaireQuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireVMMapper;
import com.briup.apps.poll.service.IQuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {

	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	@Autowired
	private QuestionnaireVMMapper questionnaireVMMapper;

	@Autowired
	private QuestionnaireQuestionMapper qqMapper;

	@Override
	public QuestionnaireVM findById(long id) throws Exception {
		return questionnaireVMMapper.selectById(id);
	}

	@Override
	public List<Questionnaire> findAll() throws Exception {
		QuestionnaireExample example = new QuestionnaireExample();
		return questionnaireMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		questionnaireMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void saveorUpdate(Questionnaire questionnaire, long[] ids) throws Exception {
		// TODO Auto-generated method stub
		if (questionnaire.getId() == null) {
			questionnaireMapper.insert(questionnaire);
			for (long id : ids) {
				QuestionnaireQuestion qq = new QuestionnaireQuestion();
				qq.setQuestionId(id);
				;
				qq.setQuestionId(questionnaire.getId());
				qqMapper.insert(qq);
			}
		} else {
			// 更新问卷信息
			// 删除问卷下所有问题的关系
			QuestionnaireQuestionExample qqExample =
					new QuestionnaireQuestionExample();
			qqExample.createCriteria().
			andQuestionnaireIdEqualTo(questionnaire.getId());
			qqMapper.deleteByExample(qqExample);
			// 重新维护问卷和问题的关系
			for (long id : ids) {
				QuestionnaireQuestion qq = 
						new QuestionnaireQuestion();
				qq.setQuestionId(id);
				qq.setQuestionId(questionnaire.getId());
				qqMapper.insert(qq);
			}
			// 更新问卷信息
			questionnaireMapper.updateByPrimaryKey(questionnaire);

		}
	}

}
