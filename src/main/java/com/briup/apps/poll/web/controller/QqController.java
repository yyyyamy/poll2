package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Qq;
import com.briup.apps.poll.bean.extend.QqVM;
import com.briup.apps.poll.service.IQqService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//import io.swagger.annotations.Api;
@Api(description="问题问卷接口")
@RestController
@RequestMapping("/qq")
public class QqController {
@Autowired
private IQqService qqService;


@ApiOperation(value="保存或更新课程信息",
		notes="如果参数中包含了id,说明这是一个更新操作。如果参数中没有包含id，说明这是一个保存操作")
@PostMapping("saveOrUpdateQq")
public MsgResponse saveOrUpdateQq(Qq qq){
	try {
		if(qq!=null && qq.getId()!=null){
			qqService.update(qq);
		} else {
			qqService.save(qq);
		}
		
		return MsgResponse.success("保存或更新成功", null);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}

@ApiOperation(value="查询问题问卷信息",notes="每个问题问卷中包含问卷的信息和问题的信息")
@GetMapping("findAllQqVM")
public MsgResponse findAllQqVM(){
	try {
		List<QqVM> list=qqService.findAllQqVM();
		return MsgResponse.success("success", list);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
@ApiOperation(value="查询问题问卷信息")
@GetMapping("findAllQq")
public MsgResponse findAllQq(){
	try {
		List<Qq>list=qqService.findAll();
		return MsgResponse.success("success", list);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}


}
