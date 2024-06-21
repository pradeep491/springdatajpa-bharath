package com.test.springdata.repository;

import com.test.springdata.entity.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    @Query("from Student")
    public List<Student> findAllStudents();

    @Query("select e.firstName,e.lastName from Student e")
    List<Object[]> findAllStudentsPartialData();

    @Query("select s from Student s where s.firstName=:fname")
    public List<Student> findAllStudentsByFirstName(@Param("fname") String name);

    /*@Query("select s from Student s where s.score >:min and s.score<:max")*/
    @Query("select s from Student s where s.score between :min and :max")
    List<Student> findStudentsForGivenScores(@Param("min") int min
            , @Param("max") int max);

    @Query("delete from Student where firstName=:fname")
    @Modifying
    void deleteStudentByFirstName(@Param("fname") String fname);

    //Paging Implementation
    @Query("from Student")
    public List<Student> findAllStudents(Pageable pageable);

    //Native SQL Queries
    @Query(value = "select * from student", nativeQuery = true)
    List<Student> findALlStudentsNQ();

    @Query(value = "select * from student where fName=:fname", nativeQuery = true)
    List<Student> findByFirstNQ(@Param("fname") String firstName);

    @Query(value="select s.fName from student s",nativeQuery = true)
    List<Object[]> findAllStudentsPartialDataNQ();
}
