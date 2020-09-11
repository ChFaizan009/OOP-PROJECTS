package edu.uog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.uog.Student.model.Student;
import edu.uog.Student.model.Course;

public interface studentRepository extends JpaRepository<Student, Long> {
	
	@Query(value = "select * from Student where ISACTIVE='N'", nativeQuery = true)
	public List<Student> findActive();
	
	@Query(value = "select * from  where (STUDENT_ID like ?1 or STUDENT_NAME like ?1) and ISACTIVE='N'", nativeQuery = true)
	public List<Student> findBySearch(String search);	
	
	

}
