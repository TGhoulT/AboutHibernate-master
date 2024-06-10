package com.skillbox.hibernate.oneToOne;

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

public class MainEmployee {
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


        Employee employee = new Employee();
        employee.setName("Arnold. S");

        Employee employee2 = new Employee();
        employee2.setName("Silvester S.");

        Employee employee3 = new Employee();
        employee3.setName("Willis B.");


        System.out.println(employee);
        System.out.println(employee2);
        System.out.println(employee3);

        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setEmployee(employee);
        employeeDetails.setEmail("terminator@gmail.com");
        employeeDetails.setCity("California");
        session.save(employeeDetails);

        EmployeeDetails employeeDetails2 = new EmployeeDetails();
        employeeDetails2.setEmployee(employee2);
        employeeDetails2.setEmail("rembo@gmail.com");
        employeeDetails2.setCity("Atlanta");
        session.save(employeeDetails2);

        EmployeeDetails employeeDetails3 = new EmployeeDetails();
        employeeDetails3.setEmployee(employee3);
        employeeDetails3.setEmail("corben_dallas@gmail.com");
        employeeDetails3.setCity("New York");
        session.save(employeeDetails3);

        employee.setDetails(employeeDetails);
        employee2.setDetails(employeeDetails2);
        employee3.setDetails(employeeDetails3);

        session.save(employee);
        session.save(employee2);
        session.save(employee3);

        System.out.println(employeeDetails);
        System.out.println(employeeDetails2);
        System.out.println(employeeDetails3);


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