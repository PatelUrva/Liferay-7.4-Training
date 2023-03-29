create table FOO_Branch (
	uuid_ VARCHAR(75) null,
	branchId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	branchName VARCHAR(75) null,
	cityId LONG,
	address1 VARCHAR(75) null,
	address2 VARCHAR(75) null,
	countryId LONG,
	stateId LONG,
	pincode INTEGER
);

create table FOO_City (
	uuid_ VARCHAR(75) null,
	cityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	cityName VARCHAR(75) null,
	stateId LONG
);

create table FOO_Department (
	uuid_ VARCHAR(75) null,
	departmentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	departmentName VARCHAR(75) null,
	departmentHead VARCHAR(75) null
);

create table FOO_Designation (
	uuid_ VARCHAR(75) null,
	designationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	designationName VARCHAR(75) null
);

create table FOO_Employee (
	uuid_ VARCHAR(75) null,
	employeeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	employeeName VARCHAR(75) null,
	employeeMobile VARCHAR(75) null,
	employeeEmail VARCHAR(75) null,
	branchId LONG,
	departmentId LONG,
	designationId LONG
);

create table FOO_State (
	uuid_ VARCHAR(75) null,
	stateId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	stateName VARCHAR(75) null,
	countryId LONG
);