package com.springboot.springbootapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootapp.controller.inter.IGetStudent;
import com.springboot.springbootapp.model.Student;
import com.springboot.springbootapp.service.inter.IGetStudentService;

@RestController
public class GetStudent implements IGetStudent {

	@Autowired
	private IGetStudentService getStudentService;

	@Override
	@RequestMapping(value = "/getStudent/{studentID}", method = RequestMethod.GET,consumes="application/json")
	public List<Student> getStudentByID(@PathVariable String studentID) {		
		List<Student> studentList = new ArrayList<>();
		studentList.add(getStudentService.getStudentByID(studentID));
		return studentList;
	}
	
}
