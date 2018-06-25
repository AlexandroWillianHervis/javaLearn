package com.learn.java.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String zipCode;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client cliente;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private City cidade;


    public Address() {
    }

    public Address(Integer id, String street, String number, String complement, String neighborhood, String zipCode, Client cliente, City cidade) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.zipCode = zipCode;
        this.cliente = cliente;
        this.cidade = cidade;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public City getCidade() {
        return cidade;
    }

    public void setCidade(City cidade) {
        this.cidade= cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getId(), address.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
