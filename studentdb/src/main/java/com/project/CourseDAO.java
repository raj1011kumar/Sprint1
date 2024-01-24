package com.project;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CourseDAO {
    private EntityManager em;

    public CourseDAO(EntityManager em) {
        this.em = em;
    }

    // Method to add course details
    public void createCourse(Course course) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }

            em.persist(course);

            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et != null && et.isActive()) {
                et.rollback();
            }
        }
    }

    // Method to update a course
    public void updateCourse(int id, String newCourseName, String newCourseCode) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();

            if (!et.isActive()) {
                et.begin();
            }

            Course course = em.find(Course.class, id);
            if (course != null) {
                course.setCourseName(newCourseName);
                course.setCourseCode(newCourseCode);
                em.merge(course);
                et.commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
            if (et != null && et.isActive()) {
                et.rollback();
            }
        }
    }

    // Method to get details of a specific course
    public Optional<Course> getById(int id) {
        Course course = em.find(Course.class, id);

        if (course != null) {
            return Optional.of(course);
        } else {
            return Optional.empty();
        }
    }

    // Method to get all courses
    public List<Course> getAll() {
        List<Course> courses = em.createQuery("from Course", Course.class).getResultList();
        return courses;
    }

    // Method to remove a course by ID
    public void removeById(int id) {
        EntityTransaction et = null;

        Course course = em.find(Course.class, id);

        try {
            et = em.getTransaction();

            if (!et.isActive()) {
                et.begin();
            }

            em.remove(course);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et != null && et.isActive()) {
                et.rollback();
            }
        }
    }
}