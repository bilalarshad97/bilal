package com.bilal.bilalbdms.service;


import com.bilal.bilal.entity.Admin;
import com.bilal.bilal.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    public AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    public Admin getById(Long id) {
        Optional<Admin> b = adminRepository.findById(id);
        if (b.isPresent()) {

            return b.get();
        }
        // throw new DonorException("Wallet with " + id + "Dose not exists ");
        return null;  //comment when add exception
    }

    public Admin crearteOrUpdate(Admin b) {
        if (b.getId() == null) {
            adminRepository.save(b);
        } else {
            adminRepository.save(b);
        }
        return bloodtbl;
    }

    public boolean delete(Long id) {
        Optional<Admin> b = adminRepository.findById(id);
        if (b.isPresent()) {
            adminRepository.delete(b.get());
            return true;
        }

        //  throw new DonorException("Wallet with " + id + " Dose not exists ");
        return false;  //comment when add exception
    }
}

