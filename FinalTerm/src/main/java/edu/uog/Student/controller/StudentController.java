package edu.uog.Student.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
import edu.uog.Student.model.Student;
import edu.uog.repository.studentRepository;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private studentRepository studentrepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student getOne(@PathVariable Long id) {
		Student student = new Student();
		student = studentrepository.findOne(id);
		return student;
	}
	
	
	// for FindActive
	@RequestMapping(method = RequestMethod.GET)
	public List get() {
		List<Student> students = new ArrayList<Student>();
		students = studentrepository.findActive();
		return students;
		
		
	}

	
	// for Find all Data In Records
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Student> getAll() {
		List<Student> students = new ArrayList<Student>();
		students = studentrepository.findAll();
		return students;
	}
	
	// for Add Data In Records
	
	@RequestMapping(method = RequestMethod.POST)
	public Student insert(@RequestBody Student student) {
		student.setISACTIVE("N");
		student = studentrepository.saveAndFlush(student);
		return student;
	}

	// for update Data In Records
	@RequestMapping(method = RequestMethod.PUT)
	public Student update(@RequestBody Student student) {
		student = studentrepository.saveAndFlush(student);
		return student;
	}
	
	//for delete Data In Records
	@RequestMapping(method = RequestMethod.DELETE)
	public Student delete(@RequestBody Student student) {
		studentrepository.delete(student);
		return student;
	}
	
	//Search Data
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public List<Student> getSearch(@RequestBody String search) {
		List<Student> students = new ArrayList<Student>();
		students = studentrepository.findBySearch("%"+search+"%");
		return students;
	}


}