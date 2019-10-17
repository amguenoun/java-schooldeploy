package com.lambdaschool.schooldeploy.services;

import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.view.CountStudentsInCourses;

import java.util.ArrayList;

public interface CourseService
{
    ArrayList<Course> findAll();

    ArrayList<CountStudentsInCourses> getCountStudentsInCourse();

    void delete(long id);
}
