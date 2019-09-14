package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.CinemaManagerMapper;
import domain.CinemaManager;
import utils.IdentityMap;
import utils.UnitOfWork;

public class CinemaManagerService {

	
	private CinemaManagerMapper cinemaManagerMapper;
	
	public CinemaManagerService() {
		this.cinemaManagerMapper = new CinemaManagerMapper();
	}
	
	/**
	 * Collect all cinema Manager info from DB
	 * */
	public List<CinemaManager> getAllCinemaManagers(){
		List<CinemaManager> cinemaManagers = new ArrayList<CinemaManager>();
		cinemaManagers = this.cinemaManagerMapper.findAllcinemaManagers();
		return cinemaManagers;
	}
	
	/**
	 * find one specific cinema manager based on cinema managerId
	 * @param cinemaManagerId
	 * */
	public CinemaManager findCinemaManagerById(int cinemaManagerId) {
		CinemaManager cinemaManager = new CinemaManager();
		cinemaManager.setCinemaManagerId(cinemaManagerId);
		IdentityMap<CinemaManager> identityMap = IdentityMap.getInstance(cinemaManager);
		CinemaManager CinemaManagerInIdentityMap = identityMap.get(cinemaManager.getCinemaManagerId());
		if(CinemaManagerInIdentityMap != null) {
			CinemaManager result = CinemaManagerInIdentityMap;
			return result;
		}
		else {
			return cinemaManagerMapper.findcinemaManagerById(cinemaManagerId);
		}
	}
	
	/**
	 * insert cinemamanager info into DB
	 * @param cinemaManager
	 * */
	public void insertCinemaManager(CinemaManager CinemaManager) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(CinemaManager);
		UnitOfWork.getCurrent().commit();
	}
	
	/**
	 * deletet cinemamanager from DB
	 * @param cinemaManager
	 * */
	public void deleteCinemaManager(CinemaManager CinemaManager) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(CinemaManager);
		UnitOfWork.getCurrent().commit();
	}
	
	/**
	 * update cinemamanager info into DB
	 * @param cinemaManager
	 * */
	public void updateCinemaManager(CinemaManager CinemaManager) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(CinemaManager);
		UnitOfWork.getCurrent().commit();
	}
}
