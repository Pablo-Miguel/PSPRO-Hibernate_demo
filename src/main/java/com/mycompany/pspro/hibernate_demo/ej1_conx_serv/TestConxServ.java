/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pspro.hibernate_demo.ej1_conx_serv;

import java.sql.*;

/**
 *
 * @author Nitro
 */
public class TestConxServ {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hibernatedemo?useSSL=false";
        String user="root";
        String passw="";
        
        try{
            
            System.out.println("Conectando con MySQL: " + jdbcUrl);
            
            Connection connection = DriverManager.getConnection(jdbcUrl, user, passw);
            
            System.out.println("Se ha conectado con el MySQL!!");
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
    }
}
