package com.briup.apps.poll.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问题相关接口")
@RestController
@RequestMapping("/question")
public class QuestionController {
@Autowired
private IQuestionService questionService;

@ApiOperation(value="保存或修改题目信息",
notes="如果题目id不为空表示更新操作,如果题目id为空表示插入操作")
@PostMapping("saveorUpdateQuestion")
public MsgResponse saveorUpdateQuestion(QuestionVM question){
try{
questionService.saveorUpdate(question);
	return MsgResponse.success("success", null);		
} catch(Exception e){
e.printStackTrace();
return MsgResponse.error(e.getMessage());
	}
}
@ApiOperation(value="查询所有信息题目 ")
@GetMapping("findAllQuestionVm")
public MsgResponse findAllQuestionVM(){
try{
	List<QuestionVM> list=questionService.findAllQuestionVM();
	return MsgResponse.success("success",list);
			
} catch(Exception e){
e.printStackTrace();
return MsgResponse.error(e.getMessage());
	}
}
@ApiOperation(value="查询所有信息题目 ")
@GetMapping("findAllQuestion")

public MsgResponse findAllQuestion(){
try{
	List<Question> list=questionService.findAll();	
	return MsgResponse.success("success",list);
} catch(Exception e){
e.printStackTrace();
return MsgResponse.error(e.getMessage());
	}
}
}