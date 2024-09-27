package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service  // Spring bean 등록
public class UsedGoodsBO {
	
	// input:X   
	// output: 컨트롤러한테 준다. List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList() {
		List<UsedGoods> usedGoodsList = ;
		return usedGoodsList; // 컨트롤러한테 리턴
	}
}
