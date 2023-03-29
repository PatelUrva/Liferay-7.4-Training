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

package com.aixtor.training.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DesignationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DesignationLocalService
 * @generated
 */
public class DesignationLocalServiceWrapper
	implements DesignationLocalService,
			   ServiceWrapper<DesignationLocalService> {

	public DesignationLocalServiceWrapper() {
		this(null);
	}

	public DesignationLocalServiceWrapper(
		DesignationLocalService designationLocalService) {

		_designationLocalService = designationLocalService;
	}

	/**
	 * Adds the designation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designation the designation
	 * @return the designation that was added
	 */
	@Override
	public com.aixtor.training.model.Designation addDesignation(
		com.aixtor.training.model.Designation designation) {

		return _designationLocalService.addDesignation(designation);
	}

	/**
	 * Creates a new designation with the primary key. Does not add the designation to the database.
	 *
	 * @param designationId the primary key for the new designation
	 * @return the new designation
	 */
	@Override
	public com.aixtor.training.model.Designation createDesignation(
		long designationId) {

		return _designationLocalService.createDesignation(designationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the designation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designation the designation
	 * @return the designation that was removed
	 */
	@Override
	public com.aixtor.training.model.Designation deleteDesignation(
		com.aixtor.training.model.Designation designation) {

		return _designationLocalService.deleteDesignation(designation);
	}

	/**
	 * Deletes the designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation that was removed
	 * @throws PortalException if a designation with the primary key could not be found
	 */
	@Override
	public com.aixtor.training.model.Designation deleteDesignation(
			long designationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationLocalService.deleteDesignation(designationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _designationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _designationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _designationLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _designationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.training.model.impl.DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _designationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.training.model.impl.DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _designationLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _designationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _designationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.aixtor.training.model.Designation fetchDesignation(
		long designationId) {

		return _designationLocalService.fetchDesignation(designationId);
	}

	/**
	 * Returns the designation matching the UUID and group.
	 *
	 * @param uuid the designation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public com.aixtor.training.model.Designation
		fetchDesignationByUuidAndGroupId(String uuid, long groupId) {

		return _designationLocalService.fetchDesignationByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _designationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the designation with the primary key.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation
	 * @throws PortalException if a designation with the primary key could not be found
	 */
	@Override
	public com.aixtor.training.model.Designation getDesignation(
			long designationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationLocalService.getDesignation(designationId);
	}

	/**
	 * Returns the designation matching the UUID and group.
	 *
	 * @param uuid the designation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching designation
	 * @throws PortalException if a matching designation could not be found
	 */
	@Override
	public com.aixtor.training.model.Designation getDesignationByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationLocalService.getDesignationByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.training.model.impl.DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of designations
	 */
	@Override
	public java.util.List<com.aixtor.training.model.Designation>
		getDesignations(int start, int end) {

		return _designationLocalService.getDesignations(start, end);
	}

	/**
	 * Returns all the designations matching the UUID and company.
	 *
	 * @param uuid the UUID of the designations
	 * @param companyId the primary key of the company
	 * @return the matching designations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.aixtor.training.model.Designation>
		getDesignationsByUuidAndCompanyId(String uuid, long companyId) {

		return _designationLocalService.getDesignationsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of designations matching the UUID and company.
	 *
	 * @param uuid the UUID of the designations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching designations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.aixtor.training.model.Designation>
		getDesignationsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.aixtor.training.model.Designation> orderByComparator) {

		return _designationLocalService.getDesignationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of designations.
	 *
	 * @return the number of designations
	 */
	@Override
	public int getDesignationsCount() {
		return _designationLocalService.getDesignationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _designationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _designationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _designationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _designationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the designation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DesignationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param designation the designation
	 * @return the designation that was updated
	 */
	@Override
	public com.aixtor.training.model.Designation updateDesignation(
		com.aixtor.training.model.Designation designation) {

		return _designationLocalService.updateDesignation(designation);
	}

	@Override
	public DesignationLocalService getWrappedService() {
		return _designationLocalService;
	}

	@Override
	public void setWrappedService(
		DesignationLocalService designationLocalService) {

		_designationLocalService = designationLocalService;
	}

	private DesignationLocalService _designationLocalService;

}