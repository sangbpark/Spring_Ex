package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {
	
	// input: int
	// output: Review or null
	public Review selectReviewById(int id);
	
	// input: Review
	// output: void or int(수행된 행의 개수) => Mybatis가 성공된 행의 개수를 준다.
	public int insertReview(Review review);
	
	// input: 파라미터들
	// outout: int
	public int insertReviewAsFiled(
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
}
