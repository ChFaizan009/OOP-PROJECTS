package pk.ed.uog.Course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import pk.edu.uog.Course.model.Course;

public interface courseRepository extends JpaRepository<Course, Long> {


	

@Query(value = "Select * from TBLCOURSE where ISACTIVE='Y'", nativeQuery = true)
public List<Course> findActive();

@Query(value = "select * from TBLCOURSE where (COURSE_CODE like ?1 or COURSE_TITLE like ?1) and ISACTIVE='Y'", nativeQuery = true)
public List<Course> findBySearch(String search);	
}



//package pk.ed.uog.Course.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import pk.ed.uog.Course.model.Course;
//
//public interface courseRepository extends JpaRepository<Course, Long> {
//
//	@Query(value = "select * from TBLCOURSE where ISACTIVE='Y'", nativeQuery = true)
//	public List<Course> findActive();
//	
//	@Query(value = "select * from TBLCOURSE where (COURSE_CODE like ?1 or COURSE_TITLE like ?1) and ISACTIVE='Y'", nativeQuery = true)
//	public List<Course> findBySearch(String search);	
//}