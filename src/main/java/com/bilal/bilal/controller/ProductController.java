package com.bilal.bilal.controller;


import com.bilal.bilal.service.ProductService;
import com.bilal.bilal.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donor")
@CrossOrigin

public class ProductController {
    @Autowired
    private ProductService walletService;    //this object is blood tbl service in this file
    @Autowired
    private ValidationService validationService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody com.bdms.bdms.entity.Product bloodtbl, BindingResult result) {
        ResponseEntity errors = validationService.validate(result);
        if (errors != null) return errors;
        entity.Product walletSave = walletService.crearteOrUpdate(bloodtbl);
        return new ResponseEntity<entity.Product>(walletSave, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody com.bdms.bdms.entity.Product wallet, BindingResult result) {
        ResponseEntity errors = validationService.validate(result);
        if (errors != null) return errors;
        wallet.setId(id);
        entity.Product walletSave = walletService.crearteOrUpdate(wallet);
        return new ResponseEntity<com.bdms.bdms.entity.Product>(walletSave, HttpStatus.OK);
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
