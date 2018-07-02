package com.briup.apps.poll.web.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.service.IGradeService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="年级相关接口")
@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private IGradeService gradeService;
	
	@GetMapping("batchDelete")
	public MsgResponse batchDelete (Long[] ids){
		try {
			List<Long> idList=new ArrayList<>();
			for(long id:ids){
				idList.add(id);
			}
			gradeService.batchDelete(idList);
			return MsgResponse.success("批量删除成功！", idList);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception	
			return MsgResponse.error("删除失败！");
		}	
	}
	@GetMapping("deleteByIdGrade")
	public MsgResponse deleteByIdGrade(long id){
		try {
			gradeService.deleteById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation("查询所有的年级信息")
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade(){
		try {
			List<Grade> list =gradeService.findAll();
			return MsgResponse.success("success",list);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
		
	}
	@PostMapping("saveGrade")
	public MsgResponse saveGrade(Grade grade){
		try {
			gradeService.save(grade);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("updateGrade")
	public MsgResponse updateGrade(Grade grade){
		try {
			gradeService.update(grade);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
