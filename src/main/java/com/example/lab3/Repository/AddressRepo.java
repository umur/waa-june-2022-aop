package com.example.lab3.Repository;

import com.example.lab3.model.bidirectional.AddressBi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<AddressBi, Long> {
}
