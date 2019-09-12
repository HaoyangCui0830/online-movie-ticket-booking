package controller;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import dataMapper.CinemaMovieMapper;
import domain.Cinema;
import domain.CinemaMovie;
import domain.Movie;
import domain.ThreeDMovie;
import service.CinemaService;
import service.MovieService;
import service.ThreeDMovieService;

public class ManagerUpdateExistedMovieCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// TODO Auto-generated method stub
		String movieId = request.getParameter("movieId");
		String movieName = request.getParameter("movieName");
		String movieLength = request.getParameter("movieLength");
		String moviePrice = request.getParameter("moviePrice");
		String isThreeD = request.getParameter("isThreeD");
		String withFreeGlasse = request.getParameter("withFreeGlasses");
		String showInMelbourne = request.getParameter("showInMelbourne");
		String showInSydney = request.getParameter("showInSydney");
		
		Movie movie = new Movie();
		movie.setMovieId(Integer.parseInt(movieId));
		movie.setName(movieName);
		movie.setLength(Time.valueOf(movieLength));
		movie.setPrice(Float.parseFloat(moviePrice));
		
		MovieService movieService = new MovieService();
		movieService.updateMovie(movie);
		
		ThreeDMovie threeDMovie = new ThreeDMovie();
		ThreeDMovieService threeDMovieService = new ThreeDMovieService();
		threeDMovie.setHasFreeGlasses(Boolean.parseBoolean(withFreeGlasse));
		threeDMovie.setMovieId(Integer.parseInt(movieId));
		//System.out.println("3D"+isThreeD);
		if(Boolean.parseBoolean(isThreeD)) {
			threeDMovieService.insertThreeDMovie(threeDMovie);
		}
		
		CinemaMovie cinemaMovie = new CinemaMovie();
		cinemaMovie.setMovieId(Integer.parseInt(movieId));
		if(Boolean.parseBoolean(showInMelbourne)) {
			cinemaMovie.setCinemaId(1);
			CinemaMovieMapper cinemaMovieMapper = new CinemaMovieMapper();
			cinemaMovieMapper.insert(cinemaMovie);
		}
		if(Boolean.parseBoolean(showInSydney)) {
			cinemaMovie.setCinemaId(2);
			CinemaMovieMapper cinemaMovieMapper = new CinemaMovieMapper();
			cinemaMovieMapper.insert(cinemaMovie);
		}
		
		
		
		forward("/jsp/ManagerPages/ManagerHomePage.jsp");
	}
	
}