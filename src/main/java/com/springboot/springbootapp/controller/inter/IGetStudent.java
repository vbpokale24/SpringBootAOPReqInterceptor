package com.springboot.springbootapp.controller.inter;

import java.util.List;

import com.springboot.springbootapp.model.Student;

public interface IGetStudent {

	public List<Student> getStudentByID(final String id);
}
