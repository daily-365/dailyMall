package com.dailyMall.www.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dailyMall.www.dao.AdminDAO;
import com.dailyMall.www.vo.AdminAccountVO;
import com.dailyMall.www.vo.ProductFileVO;
import com.dailyMall.www.vo.ProductVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;
	
	//관리자 로그인
	@Override
	public boolean selectAdminLogin(AdminAccountVO accountVO) throws Exception {
		int result = adminDAO.selectAdminLogin(accountVO);
		
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	//물품 엑셀 업로드 데이터 삽입
	@Override
	public void insertProductExcelData(Map<String,Object> map) throws Exception {
		adminDAO.insertProductExcelData(map);
		
	}
	//물품 엑셀 업로드 이미지 입력
	@Override
	public void insertProductExcelImg(ProductFileVO productFileVO) throws Exception {
		adminDAO.insertProductExcelImg(productFileVO);
		
	}	
	
	//물품 리스트
	@Override
	public List<ProductVO> selectProductList() throws Exception {
		return adminDAO.selectProductList();
	}	
	
	//idx에 따른 물품 조회 (상세) 
	@Override
	public ProductVO selectProductByIdx(int idx) throws Exception {
		return adminDAO.selectProductByIdx(idx);
	}
	//물품 재 등록 (수정)
	@Override
	public void updateProductExcelData(ProductVO productVO) throws Exception {
		adminDAO.updateProductExcelData(productVO);
	}
	//물품 삭제
	@Override
	public void deleteProductExcelData(int idx) throws Exception {
		adminDAO.deleteProductExcelData(idx);
	}
	

	
	
	
}
