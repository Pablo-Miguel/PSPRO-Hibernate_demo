/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pspro.hibernate_demo.model;

import jakarta.persistence.*;
import java.util.Objects;

/**
 *
 * @author Nitro
 */
@Entity
@Table(name="client_order")
public class ClientOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @Column(name="details")
    private String details;
    
    @Column(name="price")
    private Double price;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_client")
    private Client client;

    public ClientOrder() {
    }

    public ClientOrder(String details, Double price) {
        this.details = details;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClientOrder other = (ClientOrder) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "ClientOrder{" + "id=" + id + ", details=" + details + ", price=" + price + ", client=" + client + '}';
    }
    
}
