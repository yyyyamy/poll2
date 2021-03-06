package com.briup.apps.poll.web.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.service.IOptionsService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="问卷相关接口")
@RestController
@RequestMapping("/options")
public class OptionsController {
@Autowired
private IOptionsService optionsService;

@GetMapping("batchDelete")
public MsgResponse batchDelete (Long[] ids){
	try {
		List<Long> idList=new ArrayList<>();
		for(long id:ids){
			idList.add(id);
		}
		optionsService.batchDelete(idList);
		return MsgResponse.success("批量删除成功！", idList);
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception	
		return MsgResponse.error("删除失败！");
	}
}
@GetMapping("deleteByIdOptions")
public MsgResponse deleteByIdOptions(long id){
	try {
		optionsService.deleteById(id);
		return MsgResponse.success("success", null);
	} catch (Exception e) {
		
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
@ApiOperation("查询所有的选项信息")
@GetMapping("findAllOptions")
public MsgResponse findAllOptions(){
	try {
		List<Options> list =optionsService.findAll();
		return MsgResponse.success("success",list);
	} catch (Exception e) {
		return MsgResponse.error(e.getMessage());
	}
	
}
@PostMapping("saveOptions")
public MsgResponse saveOptions(Options options){
	try {
		optionsService.save(options);
		return MsgResponse.success("success", null);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
@PostMapping("updateOptions")
public MsgResponse updateOptions(Options options){
	try {
		optionsService.update(options);
		return MsgResponse.success("success", null);
	} catch (Exception e) {
		
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
}
