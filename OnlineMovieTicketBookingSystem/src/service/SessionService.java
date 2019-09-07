package service;

import java.util.List;

import dataMapper.SessionMapper;
import domain.Session;
import utils.IdentityMap;
import utils.UnitOfWork;

public class SessionService {
	SessionMapper sessionMapper;
	
	public SessionService() {
		sessionMapper = new SessionMapper();
	}
	
	public List<Session> getAllSessionsByMovieId(int movieId){
		List<Session> sessions = sessionMapper.findAllSessionsByMovieId(movieId);
		return sessions;
	}
	
	public Session getSessionBySessionId(int sessionId) {
		Session session = new Session();
		session.setSessionId(sessionId);
		IdentityMap<Session> identityMap = IdentityMap.getInstance(session);
		Session sessionIdentityMap = identityMap.get(session.getSessionId());
		if(sessionIdentityMap!=null) {
			Session result = sessionIdentityMap;
			return result;
		}
		else {
			return sessionMapper.findSessionById(sessionId);
		}
	}
	
	public void insertSession(Session session) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(session);
		UnitOfWork.getCurrent().commit();
	}
	
	public void deleteSession(Session session) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(session);
		UnitOfWork.getCurrent().commit();
	}
	
	public void updateSession(Session session) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(session);
		UnitOfWork.getCurrent().commit();
	}
	
}
