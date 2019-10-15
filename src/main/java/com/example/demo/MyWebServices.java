package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyWebServices {
	
	static List<Movie> movies = new ArrayList<Movie>();
	
    static String actorsInMovie1 = "Kristen bell, Idina Menzel, Jonathan Groff, Josh Gad, Santino Fontana";
    static String actorsInMovie2 = "Andrew Jacobs, Carlos Pratts, Richard Cabral, Kimberly Ables Jindra, Eddie J. Fernandez";
    static String actorsInMovie3 = "Ian McKellen, Martin Freeman, Richard Armitage, Benedict Cumberbatch, Evangeline Lilly";
    static String actorsInMovie4 = "Leonardo DiCaprio, Jonah Hill, Margot Robbie, Matthew McConaughey, Kyle Chandler";
    static String actorsInMovie5 = "Jennifer Lawrence, Bradley Cooper, Christian Bale, Amy Adams, Jeremy Renner";
    static String actorsInMovie6 = "Will Ferrell, Steve Carell, Paul Rudd, David Koechner, Christina Applegate";
    
	static {
		movies.add(new Movie("Frozen",
	            89,
	            actorsInMovie1));
		movies.add(new Movie("Paranormal Activity: The Marked Ones",
	            39,
	            actorsInMovie2));
		movies.add(new Movie("The Hobbit: The Desolation of Smaug",
	            75,
	            actorsInMovie3));
		movies.add(new Movie("The Wolf of Wall Street",
	            76,
	            actorsInMovie4));
		movies.add(new Movie("American Hustle",
	            93,
	            actorsInMovie5));
		movies.add(new Movie("Anchroman 2: The Legend Continues",
	            75,
	            actorsInMovie6));
	}

	@RequestMapping( value = "/movie", method = RequestMethod.GET)
	public List<Movie> doGetMovies()
	{
		return movies;
	}
	
	@RequestMapping( value = "/movie/{name}", method = RequestMethod.GET)
	public Movie doGetMovieById(@PathVariable("name") String name)
	{
		for(Movie m : movies)
		{
			if (m.getName() == name)
			{
				return m;
			}
		}
		return null;
	}	
	
	
	@RequestMapping( value = "/movie", method = RequestMethod.POST)
	public String doPostMovies(@RequestBody Movie m)
	{
		movies.add(m);
		return "Success!";
	}
	
	@RequestMapping( value = "/movie/{name}", method = RequestMethod.PUT)
	public String doPutMovies(@RequestBody Movie sent, @PathVariable("name") String name)
	{
		for(Movie m : movies)
		{
			if (m.getName() == name)
			{
//				c.setId( sent.getId());
//				c.setTitle( sent.getTitle());
				return "UPDATED!";
			}
		}
		return "NOT FOUND!";
	}
	
	@RequestMapping( value = "/movie/{name}", method = RequestMethod.DELETE)
	public String doDeleteMovies(@PathVariable("name") String name)
	{
		Movie del = null;
		for(Movie m : movies)
		{
			if (m.getName() == name)
			{
				del = m;
			}
		}
		if (del != null)
		{
			movies.remove(del);
			return "Movie deleted!";
		}
		return "Movie not found!";
	}

}
