package com.alexrsnchz.mobelia.controller;

import com.alexrsnchz.mobelia.model.Address;
import com.alexrsnchz.mobelia.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAll();

        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Address address = addressService.getById(id);

        return ResponseEntity.ok(address);
    }

    @PostMapping("/address")
    public ResponseEntity<Address> createAddress(@Valid @RequestBody Address address) {
        Address addressToCreate = addressService.create(address);

        return ResponseEntity.status(201).body(addressToCreate);
    }

    @PutMapping("/address/{id}")
    public ResponseEntity<Address> updateAddress(@Valid @RequestBody Address address, @PathVariable Long id) {
        Address addressToUpdate = addressService.update(address, id);

        return ResponseEntity.ok(addressToUpdate);
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
