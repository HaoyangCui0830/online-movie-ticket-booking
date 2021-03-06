package domain;

import dataMapper.CinemaMapper;

/**
 * As according to our case, cinema managers have no right to edit Cinema
 * attributes, so the class could only load all attributes at once, so 
 * lazy load (ghost) is not applied here
 * */
public class Cinema extends DomainObject{
	private int cinemaId = -1;
	private String name;
	private String address;


	/**
	 * @param cinemaId
	 * @param name
	 * @param address
	 * @param movies
	 */
	public Cinema(int cinemaId, String name, String address) {
		super();
		this.cinemaId = cinemaId;
		this.name = name;
		this.address = address;
		
	}

	
	
	/**
	 * 
	 */
	public Cinema() {
		super();
	}



	/**
	 * @return the cinemaId
	 */
	public int getCinemaId() {
		return cinemaId;
	}



	/**
	 * @param cinemaId the cinemaId to set
	 */
	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}



	/**
	 * @param name
	 * @param address
	 */
	public Cinema(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public int getId() {
		return this.cinemaId;
	}
	
}
