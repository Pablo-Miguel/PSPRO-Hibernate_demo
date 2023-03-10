/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pspro.hibernate_demo.ej3_list_users;

import com.mycompany.pspro.hibernate_demo.model.User;
import java.io.File;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author Nitro
 */
public class Ejemplo3 {
    public static void main(String[] args) {
        File f = new File("hibernate.cfg.xml");
        SessionFactory factory = new Configuration().configure(f).addAnnotatedClass(User.class).buildSessionFactory();
            
        Session session = factory.openSession();
            
        try {
            
            User user = new User("Pablo");
            
            session.beginTransaction();
            
            Query<User> query = session.createQuery("from User");
            Ejemplo3.mostrarQuery(query);
            
            query = session.createQuery("from User u where u.name='Pablo' ");
            Ejemplo3.mostrarQuery(query);
            
            query = session.createQuery("from User u where u.name='Pablo' or u.id=2");
            Ejemplo3.mostrarQuery(query);
            
            session.getTransaction().commit();
            
            session.close();
            
        } finally {
            
            factory.close();
            
        }
        
    }
    
    private static void mostrarQuery(Query<User> query){
        List<User> users = query.list();
        for(User u : users){
            System.out.println(u);
        }
    }
}
