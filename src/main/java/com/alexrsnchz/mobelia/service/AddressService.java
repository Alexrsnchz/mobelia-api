package com.alexrsnchz.mobelia.service;

import com.alexrsnchz.mobelia.exception.ResourceNotFoundException;
import com.alexrsnchz.mobelia.model.Address;
import com.alexrsnchz.mobelia.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address getById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address not found"));
    }

    public Address create(Address address) {
        return addressRepository.save(address);
    }

    public Address update(Address address, Long id) {
        Address addressToUpdate = addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address not found"));

        addressToUpdate.setType(address.getType());
        addressToUpdate.setName(address.getName());
        addressToUpdate.setNumber(address.getNumber());
        addressToUpdate.setZipCode(address.getZipCode());
        addressToUpdate.setCity(address.getCity());
        addressToUpdate.setProvince(address.getProvince());

        return addressRepository.save(addressToUpdate);
    }

    public void deleteById(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new ResourceNotFoundException("Address not found");
        }

        addressRepository.deleteById(id);
    }

}
