package com.springboot.springbootapp.service.inter;

import com.springboot.springbootapp.model.Student;

public interface IGetStudentService {

	public Student getStudentByID(final String id);
}
