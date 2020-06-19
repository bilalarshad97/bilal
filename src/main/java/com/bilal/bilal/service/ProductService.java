package com.bilal.bilal.service;

import com.bilal.bilal.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    public ProductRepository Repository;

    public List<com.bdms.bdms.entity.Product> getAll() {
        return Repository.findAll();
    }

    public com.bilal.bilal.entity.Product getById(Long id) {
        Optional<com.bdms.bdms.entity.Product> b = Repository.findById(id);
        if (b.isPresent()) {

            return b.get();
        }
        // throw new DonorException("Wallet with " + id + "Dose not exists ");
        return null;  //comment when add exception
    }

    public entity.Product crearteOrUpdate(com.bdms.bdms.entity.Product bloodtbl) {
        if (b.getId() == null) {
            Repository.save(bloodtbl);
        } else {
            Repository.save(bloodtbl);
        }
        return b;
    }

    public boolean delete(Long id) {
        Optional<com.bdms.bdms.entity.Product> bloodtbl = Repository.findById(id);
        if (bloodtbl.isPresent()) {
            Repository.delete(bloodtbl.get());
            return true;
        }

        //  throw new DonorException("Wallet with " + id + " Dose not exists ");
        return false;  //comment when add exception
    }
}
