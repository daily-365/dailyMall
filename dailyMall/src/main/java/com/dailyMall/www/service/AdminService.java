package com.dailyMall.www.service;


import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.dailyMall.www.vo.AdminAccountVO;
import com.dailyMall.www.vo.ProductFileVO;
import com.dailyMall.www.vo.ProductVO;

public interface AdminService {
	
	//관리자 로그인
	public boolean selectAdminLogin(AdminAccountVO accountVO)throws Exception;
	//물품 엑셀 업로드 데이터 입력
	public void insertProductExcelData(Map<String,Object> map)throws Exception;
	//물품 엑셀 업로드 이미지 입력
	public void insertProductExcelImg(ProductFileVO productFileVO)throws Exception;
	//물품 리스트
	public List<ProductVO>selectProductList()throws Exception;
	//idx에 따른 물품 조회 (상세) 
	public ProductVO selectProductByIdx(int idx)throws Exception;
	//물품 재등록(수정)
	public void updateProductExcelData(ProductVO productVO)throws Exception;
	//물품 삭제
	public void deleteProductExcelData(int idx)throws Exception;
}
