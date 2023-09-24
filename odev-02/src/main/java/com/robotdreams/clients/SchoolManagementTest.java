package com.robotdreams.clients;


import com.robotdreams.models.*;
import com.robotdreams.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;

public class SchoolManagementTest {
    public static void main(String[] args) {

        System.out.println("Start Process");

        Student student1 = new Student("Sadik Algul","Istanbul","Male","1982");
        Course course1 = new Course("Math","M101",5);
        Course course2 = new Course("Bio","B101",4);


        SalaryType salaryType1 = new SalaryType("H");
        SalaryType salaryType2 = new SalaryType("F");

        Instructor instructor1 = new VisitingInstructor("Koray Guney","12345",salaryType1);

        Instructor instructor2 = new PermanentInstructor("Albert Einstein","1357777",salaryType2);


       // course1.getStudentList().add(student1);
        course1.setCourseInstructor(instructor1);

       // course2.getStudentList().add(student1);
        course2.setCourseInstructor(instructor2);

        student1.getCourseList().add(course1);
        student1.getCourseList().add(course2);

        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(student1);

            entityManager.persist(salaryType1);
            entityManager.persist(salaryType2);

            entityManager.persist(instructor1);
            entityManager.persist(instructor2);

            entityManager.persist(course1);
            entityManager.persist(course2);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

        System.out.println("End Process");
    }
}