package com.skillbox.hibernate.manyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class MainUniversity {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .getMetadataBuilder()
                .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
                .build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        University university = new University();
        university.setTitle("MIFI");
//        university.setStudents();
        University university2 = new University();
        university2.setTitle("MGU");
//
//        University university = session.get(University.class, "MIFI");
//
//        Student student = session.get(Student.class, "Ivan");


//
        Student student = new Student();
        student.setName("Andrey");
        student.setUniversity(university);

        Student student2 = new Student();
        student2.setName("Ivan");
        student2.setUniversity(university2);

        Student student3 = new Student();
        student3.setName("Arseniy");
        student3.setUniversity(university);

        university.setStudents(List.of(student, student3));
        university2.setStudents(List.of(student2));

        session.save(university);
        session.save(university2);
        session.save(student);
        session.save(student2);
        session.save(student3);

        System.out.println("MIFI students: " + university.getStudents() + "\nMGU students: " + university2.getStudents());

        transaction.commit();
        sessionFactory.close();
    }
}
