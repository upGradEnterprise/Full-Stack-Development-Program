package com.zeta.spring.ioc;

import com.zeta.spring.ioc.bean.Movie;
import com.zeta.spring.ioc.bean.Movies;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringIoCTest {
    public static void main(String[] args) {
        // Create a Spring Container
        ApplicationContext context =
                new ClassPathXmlApplicationContext("XmlApplicationContext.xml");

        // Retrieve List from the Spring Container
//        Movies movies = (Movies) context.getBean("movies");
//        List<Movie> movieList = movies.getMovieList();
//        for (Movie movie : movieList) {
//            System.out.println(movie);
//        }

        Movie movie01 = (Movie) context.getBean("movie01");
        Movie movie02 = (Movie) context.getBean("movie02");
        Movie movie03 = (Movie) context.getBean("movie03");

        System.out.println(movie01);
        System.out.println(movie02);
        System.out.println(movie03);

        System.gc(); // Destroy Objects
    }
}