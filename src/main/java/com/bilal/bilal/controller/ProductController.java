package com.bilal.bilal.controller;


import com.bilal.bilal.service.ProductService;
import com.bilal.bilal.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin

public class ProductController {
    @Autowired
    private ProductService walletService;    //this object is blood tbl service in this file
    @Autowired
    private ValidationService validationService;
int i;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody com.bilal.bilal.entity.Product bloodtbl, BindingResult result) {
        ResponseEntity errors = validationService.validate(result);
        if (errors != null) return errors;
        com.bilal.bilal.entity.Product walletSave = walletService.crearteOrUpdate(bloodtbl);
        return new ResponseEntity<com.bilal.bilal.entity.Product>((MultiValueMap<String, String>) walletSave, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody com.bilal.bilal.entity.Product wallet, BindingResult result) {
        ResponseEntity errors = validationService.validate(result);
        if (errors != null) return errors;
        wallet.setId(id);
        com.bilal.bilal.entity.Product walletSave = walletService.crearteOrUpdate(wallet);
        return new ResponseEntity<com.bilal.bilal.entity.Product>((MultiValueMap<String, String>) walletSave, HttpStatus.OK);
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
