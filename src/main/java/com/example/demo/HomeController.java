package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String index(Model model){
        Set<Movie> movies = new HashSet<Movie>();
        Set<Actor> actors = new HashSet<Actor>();

        Actor actor = new Actor();
        actor.setStagename("Big Bird");
        actor.setRealname("Big ol' Birdie");
        actors.add(actor);                  //adding big bird to list of actors


        Movie movie = new Movie();
        movie.setTitle("Sesame Street");
        movie.setDescription("Kids TV show");
        movie.setYear(1990);
        movie.setCast(actors);              //adding big bird to cast member of movie



        Movie movie2 = new Movie();
        movie2.setTitle("Bird Bird Movie");
        movie2.setDescription("Crazy bird movie");
        movie2.setYear(1980);
        movie.setCast(actors);              //adding "big Bird" to cast member of movie

        movies.add(movie);                  //add "sesame street" to movies
        movies.add(movie2);                  //add "sesame street" to movies

        actor.setMovies(movies);
        actorRepository.save(actor);
        movieRepository.save(movie);
        movieRepository.save(movie2);


        model.addAttribute("actors", actorRepository.findAll());
        return "index";

    }



}
