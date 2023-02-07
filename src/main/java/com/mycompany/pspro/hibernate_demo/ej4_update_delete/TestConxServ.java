/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pspro.hibernate_demo.ej4_update_delete;

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
public class TestConxServ {
    public static void main(String[] args) {
        File f = new File("hibernate.cfg.xml");
        SessionFactory factory = new Configuration().configure(f).addAnnotatedClass(User.class).buildSessionFactory();
            
        Session session = factory.openSession();
            
        try {
            
            Integer userId = 1;
            
            //Primera forma de hacer un update
            session.beginTransaction();
            
            User user = session.get(User.class, userId);
            user.setName("Juan");
            
            session.getTransaction().commit();
            
            System.out.println("User actualizado de la forma 1 correctamente!!");
            
            /*
            //Segunda forma de hacer un update
            session.beginTransaction();
            
            session.createQuery("update user u set u.name='Juan' where u.name like 'M%'").executeUpdate();
            
            session.getTransaction().commit();
            
            System.out.println("User actualizado de la forma 2 correctamente!!");
            
            session.beginTransaction();
            
            session.createQuery("delete user u where u.id=" + userId).executeUpdate();
            
            session.getTransaction().commit();
            
            System.out.println("User eliminado correctamente!!");
            */
            
            session.close();
            
        } finally {
            
            factory.close();
            
        }
        
    }
    
    private static void mostrarQuery(Query<User> query){
        List<User> users = query.getResultList();
        for(User u : users){
            System.out.println(u);
        }
    }
}
