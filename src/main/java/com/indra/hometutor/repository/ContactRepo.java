package com.indra.hometutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.hometutor.module.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer>{

}
