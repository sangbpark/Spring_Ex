package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	// 순수 JPA vs Spring Data JPA
	
	// public StudentEntity save(StudentEntity studentEntity);
	// public Optional<StudentEntity> findById(int id);
	// public void delete(StudentEntity studentEntity);
	
	// public List<StudentEntity> findAll();
	// JPQL 메소드
	public List<StudentEntity> findAllByOrderByIdDesc();
	
	public List<StudentEntity> findTop3ByOrderByIdDesc();

	public List<StudentEntity> findByName(String name);
	
	public List<StudentEntity> findByNameIn(List<String> names);
	
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	
	public List<StudentEntity> findByEmailContains(String keyword);
	
	public List<StudentEntity> findByNameStartingWith(String keyword);
	
	public List<StudentEntity> findByIdBetween(int startId, int endId);
}
