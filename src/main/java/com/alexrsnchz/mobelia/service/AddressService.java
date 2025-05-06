package com.alexrsnchz.mobelia.service;

import com.alexrsnchz.mobelia.model.Address;
import com.alexrsnchz.mobelia.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Optional<Address> getById(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new RuntimeException("Address not found");
        }

        return addressRepository.findById(id);
    }

    public Address create(Address address) {
        return addressRepository.save(address);
    }

    public Address update(Address address, Long id) {
        return addressRepository.save(address);
    }

    public void deleteById(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new RuntimeException("Address not found");
        }

        addressRepository.deleteById(id);
    }

}
