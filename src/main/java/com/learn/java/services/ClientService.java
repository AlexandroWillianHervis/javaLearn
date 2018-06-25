package com.learn.java.services;

import com.learn.java.domain.Client;
import com.learn.java.repositories.ClientRepository;
import com.learn.java.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    public Client search(Integer id) {
        Optional<Client> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
    }
}
