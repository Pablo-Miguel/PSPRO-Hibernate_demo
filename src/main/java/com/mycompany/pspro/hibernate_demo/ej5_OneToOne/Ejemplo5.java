/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pspro.hibernate_demo.ej5_OneToOne;

import com.mycompany.pspro.hibernate_demo.model.Address;
import com.mycompany.pspro.hibernate_demo.model.Person;
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
public class Ejemplo5 {
    public static void main(String[] args) {
        
        File f = new File("hibernate.cfg.xml");
        SessionFactory factory = new Configuration()
                .configure(f)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
        
        Session session = factory.openSession();
            
        try {
            Person person = new Person("Pablo");
            Address address = new Address("Las Palmeras");
            
            //Asociamos las tablas/objetos
            person.setAddress(address);
            
            //Guardamos en la BBDD
            session.beginTransaction();
            
            session.persist(person);
            
            session.getTransaction().commit();
            
            System.out.println("Se ha guardado las tablas correctamente!!");
            
            session.close();
            
        } finally {
            
            factory.close();
            
        }
    }
}
