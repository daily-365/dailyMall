package com.dailyMall.www.vo;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {

	private int rnum;
	
	private int idx;
	private String cord;
	private String category;
	private String foodtype;
	private String name;
	private String option;
	private String size;
	private int price;
	private String producer;
	private String origin;
	private String manufacturing;
	private String ariculturalYn;
	private String livestock;
	private String importedYn;
	private String composition;
	private String storage;
	private String caution;
	private String consulation;
	private String multipleYn;
	private String freeYn;
	private java.util.Date regDate;
	
	
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCord() {
		return cord;
	}
	public void setCord(String cord) {
		this.cord = cord;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getFoodtype() {
		return foodtype;
	}
	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getManufacturing() {
		return manufacturing;
	}
	public void setManufacturing(String manufacturing) {
		this.manufacturing = manufacturing;
	}
	public String getAriculturalYn() {
		return ariculturalYn;
	}
	public void setAriculturalYn(String ariculturalYn) {
		this.ariculturalYn = ariculturalYn;
	}
	public String getLivestock() {
		return livestock;
	}
	public void setLivestock(String livestock) {
		this.livestock = livestock;
	}
	public String getImportedYn() {
		return importedYn;
	}
	public void setImportedYn(String importedYn) {
		this.importedYn = importedYn;
	}
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getCaution() {
		return caution;
	}
	public void setCaution(String caution) {
		this.caution = caution;
	}
	public String getConsulation() {
		return consulation;
	}
	public void setConsulation(String consulation) {
		this.consulation = consulation;
	}
	public String getMultipleYn() {
		return multipleYn;
	}
	public void setMultipleYn(String multipleYn) {
		this.multipleYn = multipleYn;
	}
	public String getFreeYn() {
		return freeYn;
	}
	public void setFreeYn(String freeYn) {
		this.freeYn = freeYn;
	}
	public java.util.Date getRegDate() {
		return regDate;
	}
	public void setRegDate(java.util.Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "ProductVO [idx=" + idx + ", cord=" + cord + ", category=" + category + ", foodtype=" + foodtype
				+ ", name=" + name + ", option=" + option + ", size=" + size + ", price=" + price + ", producer="
				+ producer + ", origin=" + origin + ", manufacturing=" + manufacturing + ", ariculturalYn="
				+ ariculturalYn + ", livestock=" + livestock + ", importedYn=" + importedYn + ", composition="
				+ composition + ", storage=" + storage + ", caution=" + caution + ", consulation=" + consulation
				+ ", multipleYn=" + multipleYn + ", freeYn=" + freeYn + ", regDate=" + regDate + "]";
	}
	
	
	
}
