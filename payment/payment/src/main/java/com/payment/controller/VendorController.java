package com.payment.controller;

import com.payment.entities.Email;
import com.payment.entities.Vendor;
import com.payment.services.EmailService;
import com.payment.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/vendors")
public class VendorController {
    @Autowired
    private VendorService vendorService;
    @Autowired
    private EmailService emailService;

    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.saveVendor(vendor);
    }

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @PostMapping("/send-emails")
    public ResponseEntity<List<Email>> sendEmails(@RequestBody List<Email> emailRequests) {
        List<Email> sentEmails = emailRequests.stream()
                .map(emailRequest -> emailService.sendEmail(
                        emailRequest.getRecipientName(),
                        emailRequest.getRecipientEmail(),
                        emailRequest.getUpi(),
                        emailRequest.getMessage()))
                .toList();
        return ResponseEntity.ok(sentEmails);
    }
    @GetMapping("/emails")
    public ResponseEntity<List<Email>> getAllEmails() {
        List<Email> emails = emailService.getAllEmails();
        return ResponseEntity.ok(emails);
    }
}