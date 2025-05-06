package com.alexrsnchz.mobelia.repository;

import com.alexrsnchz.mobelia.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
