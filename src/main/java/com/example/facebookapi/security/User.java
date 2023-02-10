package com.example.facebookapi.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "users")
public class User {
    public User(){
       created_at = LocalDateTime.now();
       failed_logins = 0;
    }
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String role;
   private String otp;
   private LocalDateTime otp_expires_in;
   private String password;
    private int failed_logins;
    private int customer_id;
    private boolean status;
    private LocalDateTime last_login;
    private LocalDateTime created_at;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public LocalDateTime getOtp_expires_in() {
        return otp_expires_in;
    }

    public void setOtp_expires_in(LocalDateTime otp_expires_in) {
        this.otp_expires_in = otp_expires_in;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFailed_logins() {
        return failed_logins;
    }

    public void setFailed_logins(int failed_logins) {
        this.failed_logins = failed_logins;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getLast_login() {
        return last_login;
    }

    public void setLast_login(LocalDateTime last_login) {
        this.last_login = last_login;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
