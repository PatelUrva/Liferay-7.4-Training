package com.aixtor.training.employee.bean;

public class ViewCustomBranchBean {
	
	private long branchId;
	private String branchName;
	private String country;
	private String state;
	private String city;
	private long countryId;
	private long stateId;
	private long cityId;
	private String address1;
	private String address2;
	private int pincode;
	
	

	@Override
	public String toString() {
		return "ViewCustomBranchBean [branchId=" + branchId + ", branchName=" + branchName + ", country=" + country
				+ ", state=" + state + ", city=" + city + ", countryId=" + countryId + ", stateId=" + stateId
				+ ", cityId=" + cityId + ", address1=" + address1 + ", address2=" + address2 + ", pincode=" + pincode
				+ "]";
	}

	public ViewCustomBranchBean(long branchId, String branchName, String country, String state, String city,
			long countryId, long stateId, long cityId, String address1, String address2, int pincode) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.country = country;
		this.state = state;
		this.city = city;
		this.countryId = countryId;
		this.stateId = stateId;
		this.cityId = cityId;
		this.address1 = address1;
		this.address2 = address2;
		this.pincode = pincode;
	}

	public ViewCustomBranchBean(long branchId, String branchName, long countryId, long stateId, long cityId,
			String address1, String address2, int pincode) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.countryId = countryId;
		this.stateId = stateId;
		this.cityId = cityId;
		this.address1 = address1;
		this.address2 = address2;
		this.pincode = pincode;
	}

	public ViewCustomBranchBean(long branchId, String branchName, String country, String state, String city,
			String address1, String address2, int pincode) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.country = country;
		this.state = state;
		this.city = city;
		this.address1 = address1;
		this.address2 = address2;
		this.pincode = pincode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public ViewCustomBranchBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getBranchId() {
		return branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	
	
	

}
