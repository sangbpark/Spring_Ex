package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	// 순수 JPA vs Spring Data JPA
	
	// public StudentEntity save(StudentEntity studentEntity);
	// public Optional<StudentEntity> findById(int id);
	// public void delete(StudentEntity studentEntity);
	
	// public List<StudentEntity> findAll();
	// 메소드 규칙 => JPQL
	public List<StudentEntity> findAllByOrderByIdDesc();
	
	public List<StudentEntity> findTop3ByOrderByIdDesc();

	public List<StudentEntity> findByName(String name);
	
	public List<StudentEntity> findByNameIn(List<String> names);
	
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	
	public List<StudentEntity> findByEmailContains(String keyword);
	
	public List<StudentEntity> findByNameStartingWith(String keyword);
	
	public List<StudentEntity> findByIdBetween(int startId, int endId);
	
	// ex02/select2 => JPQL(쿼리문처럼 생겼지만 엔티티에 조회) = SQL 쿼리문 아님 DB에 알아서 맞춰서 쿼리문 짜줌
//	@Query(value = "select s from StudentEntity s where s.dreamJob = :dreamJob")
//	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
	
	// ex02/select2 => SQL 쿼리문 - native query
	@Query(value = "select * from new_student where dreamJob = :dreamJob", nativeQuery = true)
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
}
