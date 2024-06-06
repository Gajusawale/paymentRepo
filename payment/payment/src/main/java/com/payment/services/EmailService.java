package com.payment.services;

import com.payment.entities.Email;
import com.payment.entities.Vendor;
import com.payment.repositories.EmailRepository;
import com.payment.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailService {

    private final EmailRepository emailRepository;
    private  final VendorRepository vendorRepository;

    @Autowired
    public EmailService(EmailRepository emailRepository, VendorRepository vendorRepository) {
        this.emailRepository = emailRepository;
        this.vendorRepository = vendorRepository;
    }

    public Email sendEmail(String recipientName, String recipientEmail, String upi, String message) {
        Email email = new Email();
        email.setRecipientName(recipientName);
        email.setRecipientEmail(recipientEmail);
        email.setUpi(upi);
        email.setMessage(message);
        email.setSentDateTime(LocalDateTime.now());
        return emailRepository.save(email);
    }

    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }
}
