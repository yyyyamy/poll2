package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.service.ICourseService;
import com.briup.apps.poll.util.MsgRespose;

import io.swagger.annotations.Api;
@Api(description="课程相关接口")
@RestController
@RequestMapping("/course")
public class CourseController {
@Autowired
private ICourseService courseService;

@PostMapping("batchDelete")
public MsgRespose batchDelete(long[] ids){
	try {
		List<Long> idList = new ArrayList<>();
		for(long id : ids){
			idList.add(id);
		}
		courseService.batchDelete(idList);
		return MsgRespose.success("批量删除成功", null);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return MsgRespose.error(e.getMessage());
	}
}

@GetMapping("findAllCourse")
public MsgRespose findAllCourse(){
	try {
		List<Course> list =courseService.findAll();
		return MsgRespose.success("success",list);
	} catch (Exception e) {
		return MsgRespose.error(e.getMessage());
	}
	
}

}
