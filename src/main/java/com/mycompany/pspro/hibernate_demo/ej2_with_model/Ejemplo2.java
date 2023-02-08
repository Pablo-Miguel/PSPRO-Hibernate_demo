/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pspro.hibernate_demo.ej2_with_model;

import com.mycompany.pspro.hibernate_demo.model.User;
import java.io.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Nitro
 */
public class Ejemplo2 {
    public static void main(String[] args) {
        File f = new File("hibernate.cfg.xml");
        SessionFactory factory = new Configuration().configure(f).addAnnotatedClass(User.class).buildSessionFactory();
            
        Session session = factory.openSession();
            
        try {
            
            User user = new User("Carlos");
            
            session.beginTransaction();
            
            //session.save(user); //-> DEPRECATED
            session.persist(user);
            
            session.getTransaction().commit();
            
            System.out.println("User insertado correctamente!!");
            
            session.beginTransaction();
            
            System.out.println("User con id: " + user.getId());
            
            User insert_user = session.get(User.class, user.getId());
            System.out.println("Get inserted user: " + insert_user);
            
            session.getTransaction().commit();
            
            session.close();
            
        } finally {
            
            factory.close();
            
        }
        
    }
}
