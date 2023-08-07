package com.indra.hometutor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.hometutor.module.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Integer>{

	List<Tutor> findAllByMobile(long tutorMobile);

}
