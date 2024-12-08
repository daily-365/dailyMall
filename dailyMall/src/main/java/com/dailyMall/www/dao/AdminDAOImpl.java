package com.dailyMall.www.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.dailyMall.www.vo.AdminAccountVO;
import com.dailyMall.www.vo.ProductFileVO;
import com.dailyMall.www.vo.ProductVO;

@Repository
public class AdminDAOImpl implements AdminDAO{

	@Autowired
	private SqlSession sqlSession;
	
	//관리자 로그인
	@Override
	public int selectAdminLogin(AdminAccountVO accountVO) throws Exception {
		return sqlSession.selectOne("AdminMapper.selectAdminLogin",accountVO);
	}
	//물품 엑셀 업로드 데이터 입력
	@Override
	public void insertProductExcelData(Map<String,Object> map) throws Exception {
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		listMap.add(map);
		paramMap.put("excelData",listMap);
		
		sqlSession.insert("AdminMapper.insertProductExcelData",paramMap);
		
	}
	//물품 엑셀 업로드 이미지 입력
	@Override
	public void insertProductExcelImg(ProductFileVO productFileVO) throws Exception {
		sqlSession.insert("AdminMapper.insertProductExcelImg",productFileVO);
		
	}
	//물품 리스트
	@Override
	public List<ProductVO> selectProductList() throws Exception {
		return sqlSession.selectList("AdminMapper.selectProductList");
	}
	
	//idx에 따른 물품 조회 (상세) 
	@Override
	public ProductVO selectProductByIdx(int idx) throws Exception {
		return sqlSession.selectOne("AdminMapper.selectProductByIdx",idx);
	}
	//물품 재등록(수정)
	@Override
	public void updateProductExcelData(ProductVO productVO) throws Exception {
		sqlSession.update("AdminMapper.updateProductExcelData",productVO);
		
	}
	//물품 삭제
	@Override
	public void deleteProductExcelData(int idx) throws Exception {
		sqlSession.delete("AdminMapper.deleteProductExcelData",idx);
	}
	

	
	
}
