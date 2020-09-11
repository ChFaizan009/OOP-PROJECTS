package pk.ed.uog.Course.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pk.ed.uog.Course.repository.courseRepository;
import pk.edu.uog.Course.model.Course;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class courseController {
	
	@Autowired
	private courseRepository courserepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Course> get() {
		List<Course> courses = new ArrayList<Course>();
		courses = courserepository.findActive();
		return courses;
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Course getOne(@PathVariable Long id) {
		Course course = new Course();
		course = courserepository.findOne(id);
		return course;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Course> getAll() {
		List<Course> courses = new ArrayList<Course>();
		courses = courserepository.findAll();
		return courses;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Course insert(@RequestBody Course course) {
		course.setISACTIVE("Y");
		course = courserepository.saveAndFlush(course);
		return course;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Course update(@RequestBody Course course) {
		course = courserepository.saveAndFlush(course);
		return course;
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public Course delete(@RequestBody Course course) {
		courserepository.delete(course);
		return course;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public List<Course> getSearch(@RequestBody String search) {
		List<Course> courses = new ArrayList<Course>();
		courses = courserepository.findBySearch("%"+search+"%");
		return courses;
	}

}