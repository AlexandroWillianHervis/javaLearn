package com.learn.java;

import com.learn.java.domain.*;
import com.learn.java.domain.enums.ClientType;
import com.learn.java.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository  productRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Informatica");
        Category cat2 = new Category(null, "Escritorio");

        Product p1 = new Product(null, "Computador", 2000.00);
        Product p2 = new Product(null, "Impressora", 800.00);
        Product p3 = new Product(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));


        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));


        State est1 = new State(null, "Minas Gerais");
        State est2 = new State(null, "Sao Paulo");

        City c1 = new City(null, "Uberlandia", est1);
        City c2 = new City(null, "Sao Paulo", est2);
        City c3 = new City(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        stateRepository.saveAll(Arrays.asList(est1, est2));
        cityRepository.saveAll(Arrays.asList(c1, c2, c3));

        Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PESSOAFISICA);

        cli1.getPhones().addAll(Arrays.asList("27363326", "93838393"));

        Address e1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
        Address e2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        clientRepository.saveAll(Arrays.asList(cli1));
        addressRepository.saveAll(Arrays.asList(e1, e2));

    }
}
