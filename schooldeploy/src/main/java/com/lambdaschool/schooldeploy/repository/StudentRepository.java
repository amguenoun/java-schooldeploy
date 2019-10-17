package com.lambdaschool.schooldeploy.repository;

import com.lambdaschool.schooldeploy.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long>
{
    List<Student> findByStudnameContainingIgnoreCase(String name);
}
