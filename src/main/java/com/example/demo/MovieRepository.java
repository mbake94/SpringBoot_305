package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    ArrayList<Movie> findAllByYear(int year);
    // SELECT * from movie where year = 1990
    ArrayList<Movie> findAllByOrderByYearAsc();
    // Select * from movie orderby year in ascending order


}
