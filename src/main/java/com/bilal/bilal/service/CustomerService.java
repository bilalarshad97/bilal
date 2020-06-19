package com.bdms.bdms.service;

import com.bdms.bdms.entity.Bloodtbl;
import com.bilal.bilal.entity.Customer;
import com.bilal.bilal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    public CustomerRepository Repository;

    public List<Customer> getAll() {
        return Repository.findAll();
    }

    public Customer getById(Long id) {
        Optional<Customer> b = Repository.findById(id);
        if (b.isPresent()) {

            return b.get();
        }
        // throw new DonorException("Wallet with " + id + "Dose not exists ");
        return null;  //comment when add exception
    }

    public Customer crearteOrUpdate(Customer c) {
        if (c.getId() == null) {
            Repository.save(c);
        } else {
            c.save(c);
        }
        return c;
    }

    public boolean delete(Long id) {
        Optional<Customer> bloodtbl = Repository.findById(id);
        if (bloodtbl.isPresent()) {
            Repository.delete(bloodtbl.get());
            return true;
        }

        //  throw new DonorException("Wallet with " + id + " Dose not exists ");
        return false;  //comment when add exception
    }
}
