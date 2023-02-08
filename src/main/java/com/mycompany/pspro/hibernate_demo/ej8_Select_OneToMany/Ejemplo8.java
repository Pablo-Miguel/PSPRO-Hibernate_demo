/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pspro.hibernate_demo.ej8_Select_OneToMany;

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
public class Ejemplo8 {
    public static void main(String[] args) {
        File f = new File("hibernate.cfg.xml");
        SessionFactory factory = new Configuration()
                .configure(f)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(ClientOrder.class)
                .buildSessionFactory();
        
        Session session = factory.openSession();
            
        try {
            
            Integer id_client = 5;
            
            session.beginTransaction();
            
            Client client = session.get(Client.class, id_client);
            
            System.out.println(client.toString());
            for (ClientOrder order : client.getOrders()) {
                System.out.println(order.toString());
            }
            
            session.getTransaction().commit();
            
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
