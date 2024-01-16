package com.g2it.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g2it.crud.model.onetomany.Course;
import com.g2it.crud.model.onetomany.Student;
import com.g2it.crud.repository.StudentRepository;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentRepository repository;

	@PostMapping("/create")
	public void createStudent(@RequestBody Student student) {
		for (Course course : student.getCourses()) {
			course.setStudent(student);
		}
		repository.save(student);
	}

	@GetMapping("/get/{id}")
	public Student getStudentById(@PathVariable Long id) {
		Student studentRepo = repository.findStudentById(id);

		Student student = new Student();
		student.setName(studentRepo.getName());
		student.setId(studentRepo.getId());
		List<Course> courses = new ArrayList<>();
		for (Course course : studentRepo.getCourses()) {
			Course newCourse = new Course();
			newCourse.setId(course.getId());
			newCourse.setName(course.getName());
			courses.add(newCourse);
		}
		student.setCourses(courses);
		return student;
	}

}
