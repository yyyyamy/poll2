package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="课调接口")
@RestController
@RequestMapping("/survey")
public class SurveyController {
@Autowired
	private ISurveyService surveyService;
@Autowired
private IAnswersService answersService;
@ApiOperation(value="登录课调",notes="code表示课调编号")
@GetMapping(value="loginSurvey")
public MsgResponse loginSurvey(long code){
	try {
		SurveyVM surveyVM=surveyService.findById(code);
		if(surveyVM.getStatus().equals(Survey.STATUS_BEGIN)){
			return MsgResponse.success("success", surveyVM);
		}else{
			return MsgResponse.error("课调状态不合法:" +surveyVM.getStatus());
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="审核课调",notes="id=编号，status表示审核状态，0审核不通过，1审核通过")
@GetMapping(value="checkSurvey")
public MsgResponse checkSurvey( long id,int status){
	try {
		Survey survey=surveyService.findSurveyById(id);
		String message="";
		if(survey.getStatus().equals(Survey.STATUS_NO_CHECK)){
			if(status==0){
				message="审核不通过";
				survey.setStatus(survey.STATUS_CHECK_NOPASS);			
			}else{
				message="审核通过";
				survey.setStatus(survey.STATUS_CHECK_PASS);		
			}
			
		}else{
			message="课调状态不合法！";
		}
		surveyService.saveOrUpdateSurvey(survey);
		
		return MsgResponse.success("message", null);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="通过状态查询课调")
@GetMapping(value="findSurveyVMByStatus")
public MsgResponse findSurveyVMByStatus(String status){
	try {
		List<SurveyVM> list=surveyService.findByStatus(status);
		
		return MsgResponse.success("成功关闭", list);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="关闭课调")
@GetMapping(value="stopSurvey")
public MsgResponse stopSurvey(long id){
	try {
		Survey survey=surveyService.findSurveyById(id);
		survey.setStatus(Survey.STATUS_NO_CHECK);
		return MsgResponse.success("成功关闭", null);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="开启课调")
@GetMapping(value="startSurvey")
public MsgResponse startSurvey(long id){
	try {
		Survey survey=surveyService.findSurveyById(id);
		//当课调状态未开启的时候才能开启一个课调
		if(survey.getStatus().equals(survey.STATUS_INIT)){
		//修改这个课调对象		
		survey.setStatus(Survey.STATUS_BEGIN);
		String code=survey.getId().toString();
		survey.setCode(code);
		surveyService.saveOrUpdateSurvey(survey);
		return MsgResponse.success("开启成功", null);
		}else{
			return MsgResponse.success("课调状态不合法"+survey.getStatus(), null);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="通过ID查询",notes="级联查询课调关联的课程，班级，讲师，问卷")
@GetMapping(value="findSurveyById")
	public MsgResponse findSurveyById(long id){
	try {
	 SurveyVM surveyVM=surveyService.findById(id);
		return MsgResponse.success("success", surveyVM);
	} catch (Exception e) {
		return MsgResponse.error(e.getMessage());
	}
}
@ApiOperation(value="级联查询",notes="级联查询课调关联的课程，班级，讲师，问卷")
@GetMapping(value="findAllSurvey")
	public MsgResponse findAllSurvey(){
	try {
		List<SurveyVM> list=surveyService.findAll();
		return MsgResponse.success("success", list);
	} catch (Exception e) {
		return MsgResponse.error(e.getMessage());
	}
	
}

@ApiOperation(value="保存与更新课调",notes="只需要输入courseId,userId,clzz_Id,questinnsireId")
@PostMapping(value="saveOrUpadteSurvey")
	public MsgResponse saveOrUpdateSurvey(Survey survey){
	try {
		surveyService.saveOrUpdateSurvey(survey);
		return MsgResponse.success("保存与更新课调成功", null);
	} catch (Exception e) {
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="去审核课调",notes="返回课调的基本信息以及课调中的主观题答案")
@GetMapping(value="toCheckSurvey")
	public MsgResponse toCheckSurvey(long id, int singleTotal, String selectStr){
		try {
			//1、根据id查询课调信息
			SurveyVM surveyVM=surveyService.findById(id);
			//2、根据id查询课调中所有的问卷信息
			List<Answers> answers=answersService.findAnswersBySurveyId(id);
			//3、根据答卷计算出平均分
			Double averages=0.0;
			for(Answers answer:answers){
			String[] arr=selectStr.split("|");
			Double total=0.0;
			for(String a:arr){
				int select=Integer.parseInt(a);
				singleTotal+=select;
			}
			Double singleAverage=total/arr.length;
			total+=singleAverage;
			}
			//4、设置平均分
			surveyVM.setAverages(averages);
			return MsgResponse.success("success", surveyVM);
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
