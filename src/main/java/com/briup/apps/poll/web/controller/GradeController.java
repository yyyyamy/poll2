package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.service.IGradeService;
import com.briup.apps.poll.util.MsgRespose;

import io.swagger.annotations.Api;
@Api(description="班级相关接口")
@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private IGradeService gradeService;
	@GetMapping("findAllGrade")
	public MsgRespose findAllGrade(){
		try {
			List<Grade> list =gradeService.findAll();
			return MsgRespose.success("success",list);
		} catch (Exception e) {
			return MsgRespose.error(e.getMessage());
		}
		
	}
}
