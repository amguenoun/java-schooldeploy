package com.lambdaschool.schooldeploy.repository;

import com.lambdaschool.schooldeploy.models.Instructor;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface InstructorRepository extends CrudRepository<Instructor, Long>
{
    ArrayList<Instructor> findInstructorsByInstructnameEquals(String name);
}
