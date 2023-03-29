/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.aixtor.training.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;FOO_Department&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Department
 * @generated
 */
public class DepartmentTable extends BaseTable<DepartmentTable> {

	public static final DepartmentTable INSTANCE = new DepartmentTable();

	public final Column<DepartmentTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, Long> departmentId = createColumn(
		"departmentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DepartmentTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, String> departmentName = createColumn(
		"departmentName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, String> departmentHead = createColumn(
		"departmentHead", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DepartmentTable() {
		super("FOO_Department", DepartmentTable::new);
	}

}