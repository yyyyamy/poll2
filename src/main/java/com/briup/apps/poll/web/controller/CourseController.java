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
import com.briup.apps.poll.util.MsgResponse;

@RestController
@RequestMapping("/course")
public class CourseController {
@Autowired
private ICourseService courseService;

@GetMapping("batchDelete")
public MsgResponse batchDelete(Long[] ids){
	try {
		List<Long> idList=new ArrayList<>();
		for(long id:ids){
			idList.add(id);
		}
		courseService.batchDelete(idList);
		return MsgResponse.success("批量删除成功！", null);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return MsgResponse.error("删除失败！");
	
}

@GetMapping("findAllCourse")
public MsgResponse findAllCourse(){
	try {
		List<Course> list =courseService.findAll();
		return MsgResponse.success("success",list);
	} catch (Exception e) {
		return MsgResponse.error(e.getMessage());
	}
}
@GetMapping("/save")
public MsgResponse save(Course course){
	try {
		courseService.save(course);
		return MsgResponse.success("保存成功！", course);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@PostMapping("saveOrUpdateCourse")
public MsgResponse saveOrUpdateCourse(Course course){
	try {
		if(course!=null&&course.getId()!=null){
			courseService.update(course);
		}else{
			courseService.save(course);
			
		}
		return MsgResponse.success("保存或更新成功", null);
	} catch (Exception e) {
		
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@GetMapping("deleteById")
public MsgResponse deleteById(long id){
	try {
		courseService.deleteById(id);
		return MsgResponse.success("删除成功！", null);
	} catch (Exception e) {
		return MsgResponse.error("删除失败！");
	}
	
}
@GetMapping("update")
public MsgResponse update(Course course){
	try {
		courseService.update(course);
		return  MsgResponse.success("更新成功！", course);	
	} catch (Exception e) {
		return MsgResponse.error("更新失败！");
	}
	
}
@GetMapping("query")
public MsgResponse query(String keywords) throws Exception{
	List<Course> query=courseService.query(keywords);
	return MsgResponse.success("询问成功！", query);
	
}



}
