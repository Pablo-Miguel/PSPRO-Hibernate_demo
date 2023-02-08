/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pspro.hibernate_demo.ej7_OneToMany;

import com.mycompany.pspro.hibernate_demo.model.Client;
import com.mycompany.pspro.hibernate_demo.model.ClientOrder;
import java.io.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Nitro
 */
public class Ejemplo7 {
    public static void main(String[] args) {
        File f = new File("hibernate.cfg.xml");
        SessionFactory factory = new Configuration()
                .configure(f)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(ClientOrder.class)
                .buildSessionFactory();
        
        Session session = factory.openSession();
            
        try {
            
            Client client = new Client("Pablo");
            
            session.beginTransaction();
            
            session.persist(client);
            
            session.getTransaction().commit();
            
            Integer id_client = client.getId();
            
            session.beginTransaction();
            
            client = session.get(Client.class, id_client);
            ClientOrder order1 = new ClientOrder("Ordernador gamer", 1500.0);
            ClientOrder order2 = new ClientOrder("Coche Audi A1", 45000.0);
            ClientOrder order3 = new ClientOrder("Pasta termica", 2.0);
            
            client.addOrder(order1);
            client.addOrder(order2);
            client.addOrder(order3);
            
            session.persist(order1);
            session.persist(order2);
            session.persist(order3);
            
            //session.delete(client);
            
            session.getTransaction().commit();
            
            System.out.println("Orders añadidos al cliente correctamente!!");
            
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            
            session.close();
            factory.close();
            
        }
    }
}
