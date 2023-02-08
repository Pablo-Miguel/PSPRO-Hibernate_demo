/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pspro.hibernate_demo.ej6_Delete_OneToOne;

import com.mycompany.pspro.hibernate_demo.model.Address;
import com.mycompany.pspro.hibernate_demo.model.Person;
import java.io.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Nitro
 */
public class Ejemplo6 {
    public static void main(String[] args) {
        
        File f = new File("hibernate.cfg.xml");
        SessionFactory factory = new Configuration()
                .configure(f)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
        
        Session session = factory.openSession();
            
        try {
            
            Integer id_person = 2;
            
            session.beginTransaction();
            //Si no encuentra la persona devuelve null.
            Person person = session.get(Person.class, id_person);
            
            if(person != null){
                session.delete(person);
            }
            
            session.getTransaction().commit();
            
            if(person != null){
                System.out.println("Se ha borrado la persona correctamente!!");
            } else {
                System.out.println("No se ha encontrado persona");
            }
            
            session.close();
            
        } finally {
            
            factory.close();
            
        }
    }
}
