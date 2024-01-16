package com.g2it.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g2it.crud.model.onetomany.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
