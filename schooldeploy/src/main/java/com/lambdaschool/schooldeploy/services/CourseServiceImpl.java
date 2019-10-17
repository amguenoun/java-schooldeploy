package com.lambdaschool.schooldeploy.services;

import com.lambdaschool.schooldeploy.models.Course;
import com.lambdaschool.schooldeploy.models.Student;
import com.lambdaschool.schooldeploy.repository.CourseRepository;
import com.lambdaschool.schooldeploy.view.CountStudentsInCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "courseService")
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseRepository courserepos;

    @Override
    public ArrayList<Course> findAll()
    {
        ArrayList<Course> list = new ArrayList<>();
        courserepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public ArrayList<CountStudentsInCourses> getCountStudentsInCourse()
    {
        return courserepos.getCountStudentsInCourse();
    }

    @Transactional
    @Override
    public void delete(long id) throws EntityNotFoundException
    {
        if (courserepos.findById(id).isPresent())
        {
            courserepos.deleteCourseFromStudcourses(id);
            courserepos.deleteById(id);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Course save(Course course) {
        Course newCourse = new Course();

        newCourse.setCoursename(course.getCoursename());
        newCourse.setInstructor(course.getInstructor());

        ArrayList<Student> newStudents = new ArrayList<>();

        for(Student s : course.getStudents()){
            newStudents.add(s);
        }

        newCourse.setStudents(newStudents);

        return courserepos.save(newCourse);
    }
}
