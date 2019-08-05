package com.springboot.springbootapp.serviceImpl;
import org.springframework.stereotype.Service;
import com.springboot.springbootapp.model.Student;
import com.springboot.springbootapp.service.inter.IGetStudentService;

@Service
public class GetStudentService implements IGetStudentService{

	@Override
	public Student getStudentByID(String id) {
		Student student = new Student();
		student.setName("Ashish");
		student.setAge("39");	
		return student;
	}

}
