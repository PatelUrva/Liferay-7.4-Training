create index IX_1F993FFE on FOO_employee (firstName[$COLUMN_LENGTH:75$]);
create index IX_AB0828E1 on FOO_employee (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_AC9773A3 on FOO_employee (uuid_[$COLUMN_LENGTH:75$], groupId);