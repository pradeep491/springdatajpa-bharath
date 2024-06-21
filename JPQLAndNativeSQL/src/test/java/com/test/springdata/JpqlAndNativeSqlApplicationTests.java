package com.test.springdata;

import com.test.springdata.entity.Student;
import com.test.springdata.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class JpqlAndNativeSqlApplicationTests {

    @Autowired
    StudentRepository repo;

    @Test
    void contextLoads() {
    }

    @Test
    public void testStudentCreate() {
        Student s1 = new Student();
        s1.setFirstName("test");
        s1.setLastName("test");
        s1.setScore(80);

        Student s2 = new Student();
        s2.setFirstName("test1");
        s2.setLastName("test1");
        s2.setScore(72);

        repo.save(s1);
        repo.save(s2);
    }

    @Test
    public void findAll() {
        List<Student> list = repo.findAllStudents();
        System.out.println(list);
        System.out.println("============================");
        list.forEach(p -> {
            System.out.println(p.getId() + "-" + p.getFirstName() + "-" + p.getLastName() + "-" + p.getScore());
        });
    }

    @Test
    public void findAllStudentsPartial() {
        List<Object[]> partialData = repo.findAllStudentsPartialData();

        for (Object[] obj : partialData) {
            System.out.println(obj[0] + "-" + obj[1]);
        }
    }

    @Test
    public void testFindAllStudentsByFirstName() {
        List<Student> list = repo.findAllStudentsByFirstName("pradeep");
        list.forEach(p -> {
            System.out.println(p);
        });
    }

    @Test
    public void testFindAllStudentsByScores() {
        List<Student> list = repo.findStudentsForGivenScores(70, 99);
        System.out.println(list);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testDeleteStudentByFirstName() {
        repo.deleteStudentByFirstName("test");
    }

    @Test
    public void findAllWithPagination() {
        List<Student> list = repo.findAllStudents(PageRequest.of(1, 2));
        System.out.println(list);
        System.out.println("============================");
        list.forEach(p -> {
            System.out.println(p.getId() + "-" + p.getFirstName() + "-" + p.getLastName() + "-" + p.getScore());
        });
    }

    @Test
    public void findAllWithPaginationandSorting() {
        List<Student> list = repo.findAllStudents(PageRequest.of(1, 2, Sort.by("id").ascending()));
        System.out.println(list);
        System.out.println("============================");
        list.forEach(p -> {
            System.out.println(p.getId() + "-" + p.getFirstName() + "-" + p.getLastName() + "-" + p.getScore());
        });
    }

    @Test
    public void findAllWithNQ() {
        List<Student> list = repo.findALlStudentsNQ();
        list.forEach(p -> {
            System.out.println(p.getId() + "-" + p.getFirstName() + "-" + p.getLastName() + "-" + p.getScore());
        });
    }

    @Test
    public void findByFirstNameNQ() {
        List<Student> list = repo.findByFirstNQ("pradeep");
        list.forEach(p -> {
            System.out.println(p.getId() + "-" + p.getFirstName() + "-" + p.getLastName() + "-" + p.getScore());
        });
    }

    @Test
    public void findAllStudentsPartialNQ() {
        List<Object[]> partialData = repo.findAllStudentsPartialDataNQ();

        for (Object[] obj : partialData) {
            System.out.println(obj[0]);
        }
    }
}
