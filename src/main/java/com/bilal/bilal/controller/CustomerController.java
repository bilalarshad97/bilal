package com.bdms.bdms.controller;


import com.bdms.bdms.service.CustomerService;
import com.bdms.bdms.service.ValidationService;
import com.bilal.bilal.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin


public class CustomerController {

    @Autowired
    private CustomerService walletService;
    @Autowired
    private ValidationService validationService;
int i;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Customer c, BindingResult result) {
        ResponseEntity errors = validationService.validate(result);
        if (errors != null) return errors;
        Customer walletSave = walletService.crearteOrUpdate(c);
        return new ResponseEntity<Customer>(walletSave, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Customer wallet, BindingResult result) {
        ResponseEntity errors = validationService.validate(result);
        if (errors != null) return errors;
        wallet.setId(id);
        Customer walletSave = walletService.crearteOrUpdate(wallet);
        return new ResponseEntity<Customer>(walletSave, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        walletService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(walletService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(walletService.getById(id), HttpStatus.OK);
    }


}
