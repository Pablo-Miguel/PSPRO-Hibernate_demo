/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pspro.hibernate_demo.ej4_update_delete;

import com.mycompany.pspro.hibernate_demo.model.User;
import java.io.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



/**
 *
 * @author Nitro
 */
public class Ejemplo4 {
    public static void main(String[] args) {
        
        //https://www.tutorialspoint.com/hibernate/hibernate_query_language.htm --> Para consultas HQL
        
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
            
            session.beginTransaction();
            String hql = "UPDATE User set name = :name WHERE name LIKE :nameSearch";
            Query query = session.createQuery(hql);
            query.setParameter("name", "Juan");
            query.setParameter("nameSearch", "M%");
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            session.getTransaction().commit();
            
            System.out.println("User actualizado de la forma 2 correctamente!!");
            
            session.beginTransaction();
            hql = "DELETE FROM User WHERE name=:name";
            query = session.createQuery(hql);
            query.setParameter("name", "Carlos");
            result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            session.getTransaction().commit();
            System.out.println("User eliminado correctamente!!");
            
            session.close();
            
        } finally {
            
            factory.close();
            
        }
        
    }
}
