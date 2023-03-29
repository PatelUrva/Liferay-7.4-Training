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
 * The table class for the &quot;FOO_Branch&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Branch
 * @generated
 */
public class BranchTable extends BaseTable<BranchTable> {

	public static final BranchTable INSTANCE = new BranchTable();

	public final Column<BranchTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BranchTable, Long> branchId = createColumn(
		"branchId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BranchTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BranchTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BranchTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BranchTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BranchTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BranchTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BranchTable, String> branchName = createColumn(
		"branchName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BranchTable, Long> cityId = createColumn(
		"cityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BranchTable, String> address1 = createColumn(
		"address1", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BranchTable, String> address2 = createColumn(
		"address2", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BranchTable, Long> countryId = createColumn(
		"countryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BranchTable, Long> stateId = createColumn(
		"stateId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BranchTable, Integer> pincode = createColumn(
		"pincode", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private BranchTable() {
		super("FOO_Branch", BranchTable::new);
	}

}