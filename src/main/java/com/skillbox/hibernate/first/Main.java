package com.skillbox.hibernate.first;

import com.skillbox.hibernate.oneToOne.Employee;
import com.skillbox.hibernate.oneToOne.EmployeeDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
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


//        User user = session.get(User.class, "Bob");
//        User user2 = session.get(User.class, "Jack");
//        User user3 = session.get(User.class, "John");
//        User user = new User();
//        user.setName("Bob");
//        user.setScore(82);
//
//        User user2 = new User();
//        user2.setName("Jack");
//        user2.setScore(82);
//
//        User user3 = new User();
//        user3.setName("John");
//        user3.setScore(82);
//        session.save(user);
//        session.save(user2);
//        session.save(user3);


//
//        User newUser = new User();
//        newUser.setName("Andrey");
//        newUser.setScore(90);
//        session.save(newUser);
//        User updateUser = session.get(User.class, "Andrey");
////        session.delete(updateUser);
//        System.out.println(user);
//        System.out.println(user2);
//        System.out.println(user3);
//        User newUser2 = new User();
//        newUser2.setName("Hakusic");
//        newUser2.setScore(100);
//        session.save(newUser2);
////        session.delete(newUser2);
//        System.out.println(updateUser);

        transaction.commit();
        sessionFactory.close();
    }
}