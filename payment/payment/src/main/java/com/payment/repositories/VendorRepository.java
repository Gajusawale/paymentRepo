package com.payment.repositories;

import com.payment.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

   Vendor findByName(String name);
}