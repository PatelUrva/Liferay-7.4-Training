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
 * Provides a wrapper for {@link StateLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StateLocalService
 * @generated
 */
public class StateLocalServiceWrapper
	implements ServiceWrapper<StateLocalService>, StateLocalService {

	public StateLocalServiceWrapper() {
		this(null);
	}

	public StateLocalServiceWrapper(StateLocalService stateLocalService) {
		_stateLocalService = stateLocalService;
	}

	/**
	 * Adds the state to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param state the state
	 * @return the state that was added
	 */
	@Override
	public com.aixtor.training.model.State addState(
		com.aixtor.training.model.State state) {

		return _stateLocalService.addState(state);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stateLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new state with the primary key. Does not add the state to the database.
	 *
	 * @param stateId the primary key for the new state
	 * @return the new state
	 */
	@Override
	public com.aixtor.training.model.State createState(long stateId) {
		return _stateLocalService.createState(stateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stateLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stateId the primary key of the state
	 * @return the state that was removed
	 * @throws PortalException if a state with the primary key could not be found
	 */
	@Override
	public com.aixtor.training.model.State deleteState(long stateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stateLocalService.deleteState(stateId);
	}

	/**
	 * Deletes the state from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param state the state
	 * @return the state that was removed
	 */
	@Override
	public com.aixtor.training.model.State deleteState(
		com.aixtor.training.model.State state) {

		return _stateLocalService.deleteState(state);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _stateLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _stateLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stateLocalService.dynamicQuery();
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

		return _stateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.training.model.impl.StateModelImpl</code>.
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

		return _stateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.training.model.impl.StateModelImpl</code>.
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

		return _stateLocalService.dynamicQuery(
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

		return _stateLocalService.dynamicQueryCount(dynamicQuery);
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

		return _stateLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.aixtor.training.model.State fetchState(long stateId) {
		return _stateLocalService.fetchState(stateId);
	}

	/**
	 * Returns the state matching the UUID and group.
	 *
	 * @param uuid the state's UUID
	 * @param groupId the primary key of the group
	 * @return the matching state, or <code>null</code> if a matching state could not be found
	 */
	@Override
	public com.aixtor.training.model.State fetchStateByUuidAndGroupId(
		String uuid, long groupId) {

		return _stateLocalService.fetchStateByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.aixtor.training.model.State> findByCountryId(
			long countryId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _stateLocalService.findByCountryId(countryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stateLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _stateLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stateLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stateLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the state with the primary key.
	 *
	 * @param stateId the primary key of the state
	 * @return the state
	 * @throws PortalException if a state with the primary key could not be found
	 */
	@Override
	public com.aixtor.training.model.State getState(long stateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stateLocalService.getState(stateId);
	}

	/**
	 * Returns the state matching the UUID and group.
	 *
	 * @param uuid the state's UUID
	 * @param groupId the primary key of the group
	 * @return the matching state
	 * @throws PortalException if a matching state could not be found
	 */
	@Override
	public com.aixtor.training.model.State getStateByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stateLocalService.getStateByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aixtor.training.model.impl.StateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @return the range of states
	 */
	@Override
	public java.util.List<com.aixtor.training.model.State> getStates(
		int start, int end) {

		return _stateLocalService.getStates(start, end);
	}

	/**
	 * Returns all the states matching the UUID and company.
	 *
	 * @param uuid the UUID of the states
	 * @param companyId the primary key of the company
	 * @return the matching states, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.aixtor.training.model.State>
		getStatesByUuidAndCompanyId(String uuid, long companyId) {

		return _stateLocalService.getStatesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of states matching the UUID and company.
	 *
	 * @param uuid the UUID of the states
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching states, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.aixtor.training.model.State>
		getStatesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.aixtor.training.model.State> orderByComparator) {

		return _stateLocalService.getStatesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of states.
	 *
	 * @return the number of states
	 */
	@Override
	public int getStatesCount() {
		return _stateLocalService.getStatesCount();
	}

	/**
	 * Updates the state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param state the state
	 * @return the state that was updated
	 */
	@Override
	public com.aixtor.training.model.State updateState(
		com.aixtor.training.model.State state) {

		return _stateLocalService.updateState(state);
	}

	@Override
	public StateLocalService getWrappedService() {
		return _stateLocalService;
	}

	@Override
	public void setWrappedService(StateLocalService stateLocalService) {
		_stateLocalService = stateLocalService;
	}

	private StateLocalService _stateLocalService;

}