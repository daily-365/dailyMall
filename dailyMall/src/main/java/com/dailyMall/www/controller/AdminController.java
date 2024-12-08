package com.dailyMall.www.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dailyMall.www.service.AdminService;
import com.dailyMall.www.vo.AdminAccountVO;
import com.dailyMall.www.vo.ProductVO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	
	@Autowired
	private AdminService adminService;
	
	
	//관리자 메인 화면
	@RequestMapping(value = "main",method = RequestMethod.GET)
	public String getAdminMain()throws Exception{
		
		return "admin/main";
	}
	
	//관리자 로그인 화면
	@RequestMapping(value = "login",method =  RequestMethod.GET )
	public String getAdminLogin()throws Exception{
		
		return "admin/login";
	}
	
	//관리자 로그인
	@RequestMapping(value = "login",method =  RequestMethod.POST )
	public String postAdminLogin(RedirectAttributes rttr ,AdminAccountVO accountVO)throws Exception{
		boolean result = adminService.selectAdminLogin(accountVO);
		
		if(result) {
			return "redirect:/admin/main";
		}else {
			
			rttr.addFlashAttribute("failMsg","아이디와 비밀번호를 확인해 주세요");
			
			return "redirect:/admin/login";
		}
		
	}
	
	//관리자 물품 리스트 화면
	@RequestMapping(value = "product/list",method =  RequestMethod.GET )
	public String getAdminProductList(Model model)throws Exception{
		
		List<ProductVO> list = adminService.selectProductList();
		model.addAttribute("list",list);
		
		return "admin/product/list";
	}
	
	//관리자 물품 등록 화면
	@RequestMapping(value = "product/regist",method =  RequestMethod.GET )
	public String getAdminProductRegist()throws Exception{
		
		return "admin/product/regist";
	}
	//관리자 물품 상세 화면
	@RequestMapping(value = "product/detail",method =  RequestMethod.GET )
	public String getAdminProductDetail(Model model,@RequestParam("idx")int idx)throws Exception{
		ProductVO productVO = adminService.selectProductByIdx(idx);
		model.addAttribute("productVO",productVO);
		
		return "admin/product/detail";
	}
	
	//관리자 물품 엑셀 업로드
	@ResponseBody
	@RequestMapping(value = "product/excel/upload",method =  RequestMethod.POST ,produces = "application/text; charset=UTF-8;")
	public String postProductExcelUpload(@RequestParam("excelFile")MultipartFile file)throws Exception{
			
		productExcelDataUpload(file);
		    
		return "물품등록이 완료되었습니다.";
	}
	
	//관리자 물품 엑셀 재 업로드(수정)
	@ResponseBody
	@RequestMapping(value = "product/excel/update",method =  RequestMethod.POST ,produces = "application/text; charset=UTF-8;")
	public String postProductExcelUpdate(@RequestParam("excelFile")MultipartFile file,@RequestParam("idx")int idx)throws Exception{
			
		productExcelDataUpdate(file,idx);
		    
		return "수정되었습니다.";
	}
	
	//관리자 물품 정보 삭제
	@ResponseBody
	@RequestMapping(value = "product/excel/delete",method = RequestMethod.POST,produces = "application/text; charset=UTF-8;")
	public String postProductExcelDelete(@RequestParam("idx")int idx)throws Exception{
		
		adminService.deleteProductExcelData(idx);
		
		return "삭제되었습니다.";
	}

	private void productExcelDataUpload(@RequestParam("excelFile")MultipartFile file) throws Exception {
	
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Map<String, Object> map = null;
	
		for(int i=2; i<sheet.getPhysicalNumberOfRows(); i++) {
			
			map = new HashMap<String, Object>();
			
			DataFormatter formatter = new DataFormatter();
			XSSFRow row = sheet.getRow(i);
			
			String cord =formatter.formatCellValue(row.getCell(0));
			String category =formatter.formatCellValue(row.getCell(1));
			String foodtype=formatter.formatCellValue(row.getCell(2));
			String name=formatter.formatCellValue(row.getCell(3));
			String option=formatter.formatCellValue(row.getCell(4));
			String size=formatter.formatCellValue(row.getCell(5));
			String price=formatter.formatCellValue(row.getCell(6));
			String producer=formatter.formatCellValue(row.getCell(7));
			String origin=formatter.formatCellValue(row.getCell(8));
			String manufacturing=formatter.formatCellValue(row.getCell(9));
			String ariculturalYn=formatter.formatCellValue(row.getCell(10));
			String livestock=formatter.formatCellValue(row.getCell(11));
			String importedYn=formatter.formatCellValue(row.getCell(12));
			String composition=formatter.formatCellValue(row.getCell(13));
		    String storage=formatter.formatCellValue(row.getCell(14));
		    String caution=formatter.formatCellValue(row.getCell(15));
		    String consulation=formatter.formatCellValue(row.getCell(16));
		    String multipleYn=formatter.formatCellValue(row.getCell(17));
		    String freeYn=formatter.formatCellValue(row.getCell(18));
			
		    map.put("cord", cord);
		    map.put("category", category);
		    map.put("foodtype", foodtype);
		    map.put("name", name);
		    map.put("option", option);
		    map.put("size", size);
		    map.put("price", Integer.parseInt(price));
		    map.put("producer", producer);
		    map.put("origin", origin);
		    map.put("manufacturing", manufacturing);
		    map.put("ariculturalYn", ariculturalYn);
		    map.put("livestock", livestock);
		    map.put("importedYn", importedYn);
		    map.put("composition", composition);
		    map.put("storage", storage);
		    map.put("caution", caution);
		    map.put("consulation", consulation);
		    map.put("multipleYn", multipleYn);
		    map.put("freeYn", freeYn);
		    
		    adminService.insertProductExcelData(map);
		}
	}
	
	private void productExcelDataUpdate(@RequestParam("excelFile")MultipartFile file,@RequestParam("idx")int idx) throws Exception {
		
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		ProductVO productVO = new ProductVO();
	
		for(int i=2; i<sheet.getPhysicalNumberOfRows(); i++) {
			
			DataFormatter formatter = new DataFormatter();
			XSSFRow row = sheet.getRow(i);
			
			String cord =formatter.formatCellValue(row.getCell(0));
			String category =formatter.formatCellValue(row.getCell(1));
			String foodtype=formatter.formatCellValue(row.getCell(2));
			String name=formatter.formatCellValue(row.getCell(3));
			String option=formatter.formatCellValue(row.getCell(4));
			String size=formatter.formatCellValue(row.getCell(5));
			String price=formatter.formatCellValue(row.getCell(6));
			String producer=formatter.formatCellValue(row.getCell(7));
			String origin=formatter.formatCellValue(row.getCell(8));
			String manufacturing=formatter.formatCellValue(row.getCell(9));
			String ariculturalYn=formatter.formatCellValue(row.getCell(10));
			String livestock=formatter.formatCellValue(row.getCell(11));
			String importedYn=formatter.formatCellValue(row.getCell(12));
			String composition=formatter.formatCellValue(row.getCell(13));
		    String storage=formatter.formatCellValue(row.getCell(14));
		    String caution=formatter.formatCellValue(row.getCell(15));
		    String consulation=formatter.formatCellValue(row.getCell(16));
		    String multipleYn=formatter.formatCellValue(row.getCell(17));
		    String freeYn=formatter.formatCellValue(row.getCell(18));
			
		    
		    productVO.setIdx(idx);
		    
		    productVO.setCord(cord);
		    productVO.setCategory(category);
		    productVO.setFoodtype(foodtype);
		    productVO.setName(name); 
		    productVO.setOption(option);
		    productVO.setSize(size);
		    productVO.setPrice(Integer.parseInt(price));
		    productVO.setProducer(producer);
		    productVO.setOrigin(origin);
		    productVO.setManufacturing(manufacturing);
		    productVO.setAriculturalYn(ariculturalYn);
		    productVO.setLivestock(livestock);
		    productVO.setImportedYn(importedYn);
		    productVO.setComposition(composition);
		    productVO.setStorage(storage);
		    productVO.setCaution(caution);
		    productVO.setConsulation(consulation);
		    productVO.setMultipleYn(multipleYn);
		    productVO.setFreeYn(freeYn);
		    
		    adminService.updateProductExcelData(productVO);
		}
	}

}
