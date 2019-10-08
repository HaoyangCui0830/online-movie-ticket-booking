package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Movie;
import domain.User;
import service.MovieService;

public class ManagerDeleteMovieCommand extends FrontCommand{

	/**
	 * Collect movie id from presentation layer, and delete all information
	 * related in the DB
	 * */
	@Override
	public void process() throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			response.getWriter().write("please login to check your tickets");
			forward("/jsp/errorPage.jsp");
		}
		else {
			Movie movie = new Movie();
			int movieId = Integer.parseInt(request.getParameter("movieId"));
			MovieService movieService = new MovieService();
			movie = movieService.getMovieById(movieId);
			System.out.println(request.getSession().getId());
			Boolean result = movieService.deleteMovie(movie,request.getSession().getId());
			if(result == true) {
				request.setAttribute("movie", movie);
				forward("/jsp/ManagerPages/ManagerHomePage.jsp");
			}
			else {
				forward("/jsp/errorPage.jsp");
			}
		}
		
		
		
	}

}
