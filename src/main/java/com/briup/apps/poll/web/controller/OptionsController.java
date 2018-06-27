package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.service.IOptionsService;
import com.briup.apps.poll.util.MsgRespose;

import io.swagger.annotations.Api;
@Api(description="问卷相关接口")
@RestController
@RequestMapping("/options")
public class OptionsController {
@Autowired
private IOptionsService optionsService;
@GetMapping("findAllOptions")
public MsgRespose findAllOptions(){
	try {
		List<Options> list =optionsService.findAll();
		return MsgRespose.success("success",list);
	} catch (Exception e) {
		return MsgRespose.error(e.getMessage());
	}
	
}
}
