package com.payment.repositories;

import com.payment.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmailRepository extends JpaRepository<Email, Long> {

}
