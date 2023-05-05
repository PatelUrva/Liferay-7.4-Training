create index IX_65B2F582 on FOO_Branch (branchName[$COLUMN_LENGTH:75$]);
create index IX_78454D5B on FOO_Branch (cityId);
create index IX_DF1417A0 on FOO_Branch (countryId);
create index IX_5738C25B on FOO_Branch (stateId);
create index IX_6F27EC35 on FOO_Branch (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_76B7FBF7 on FOO_Branch (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_7E6333D4 on FOO_City (cityName[$COLUMN_LENGTH:75$]);
create index IX_A999BCB2 on FOO_City (stateId);
create index IX_8635A3BE on FOO_City (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_EBB001C0 on FOO_City (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_FEC5D2E2 on FOO_Department (departmentName[$COLUMN_LENGTH:75$]);
create index IX_C227FD65 on FOO_Department (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4BEA9927 on FOO_Department (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C0D21A4E on FOO_Designation (designationName[$COLUMN_LENGTH:75$]);
create index IX_E19742F8 on FOO_Designation (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_EB84277A on FOO_Designation (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D235E1E on FOO_Employee (branchId);
create index IX_9E2A44E on FOO_Employee (departmentId);
create index IX_2FEED3B5 on FOO_Employee (designationId);
create index IX_57864F9A on FOO_Employee (employeeName[$COLUMN_LENGTH:75$]);
create index IX_90E73D01 on FOO_Employee (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_716D0FC3 on FOO_Employee (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B981D2A3 on FOO_State (countryId);
create index IX_4EFCD34E on FOO_State (stateName[$COLUMN_LENGTH:75$]);
create index IX_238557D2 on FOO_State (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_37C5AAD4 on FOO_State (uuid_[$COLUMN_LENGTH:75$], groupId);