package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.service.IUserService;
import com.briup.apps.poll.util.MsgRespose;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@ApiOperation(value = "保存或更新用户信息", notes = "如果参数中包含了id,说明这是一个更新操作。如果参数中没有包含id，说明这是一个保存操作")
	@PostMapping("saveOrUpdateUser")
	public MsgRespose saveOrUpdateUser(User user) {
		try {
			if (user != null && user.getId() != null) {
				userService.update(user);
			} else {
				userService.save(user);
			}

			return MsgRespose.success("保存或更新成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}

	@ApiOperation(value = "批量删除用户信息")

	@PostMapping("batchDelete")
	public MsgRespose batchDelete(Long[] ids) {
		try {
			List<Long> idList = new ArrayList<>();
			for (long id : ids) {
				idList.add(id);
			}
			userService.batchDelete(ids);
			return MsgRespose.success("批量删除成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}

	@ApiOperation(value = "查询所有的用户信息")
	@GetMapping("findAllUser")
	public MsgRespose findAllUser() {
		try {
			List<User> list = userService.findAll();
			return MsgRespose.success("success", list);

		} catch (Exception e) {
			// TODO: handle exception
			return MsgRespose.error(e.getMessage());
		}

	}
}
