package com.learn.java.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.learn.java.domain.enums.ClientType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String cpfCnpj;
    private Integer type;

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private List<Address> enderecos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "TELEFONE ")
    private Set<String> phones = new HashSet<>();


    public Client() {
    }

    public Client(Integer id, String name, String email, String cpfCnpj, ClientType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.type = type.getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public ClientType getType() {
        return ClientType.toEnum(type);
    }

    public void setType(ClientType type) {
        this.type = type.getCod();
    }

    public List<Address> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Address> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(getId(), client.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
