package org.lessons.java.bestoftheyear.Controller;

import org.lessons.java.bestoftheyear.Classes.Movie;
import org.lessons.java.bestoftheyear.Classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class MainController {

    @GetMapping("/")
    public String home(Model model){
        String name = "Alessandro";
        model.addAttribute("name", name);
        return "home";
    }

    private List<Movie> listMovies(){

        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie(1, "Avatar"));
        movies.add(new Movie(2, "Space Jam"));
        movies.add(new Movie(3, "The Hobbit"));

        return movies;
    }

    private List<Song> listSongs(){

        List<Song> songs = new ArrayList<>();

        songs.add(new Song(1, "Uptown Funk"));
        songs.add(new Song(2, "See you again"));
        songs.add(new Song(3, "Sorry"));

        return songs;
    }

    @GetMapping("/movies")
    public String getBestMovies(Model model){

        List<String> moviesTitles = new ArrayList<>();

        for (Movie movie : listMovies()) {
            moviesTitles.add(movie.getTitle());
        }

        model.addAttribute("movies", String.join(", ", moviesTitles));
        return "movies";
    }

    @GetMapping("/songs")
    public String getBestSongs(Model model){

        List<String> songsTitles = new ArrayList<>();

        for (Song song : listSongs()) {
            songsTitles.add(song.getTitle());
        }

        model.addAttribute("songs", String.join(", ", songsTitles));
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String getMovieById(Model model, @PathVariable int id){

        String selMovie = null;

        for (Movie movie : listMovies()) {
            if(movie.getId() == id){
                selMovie = "ID: " + movie.getId() + " - " + " Title: " + movie.getTitle();
            }

            if(selMovie == null){
                selMovie = "Movie ID not found";
            }
        }

        model.addAttribute("movie", selMovie);

        return "movies";
    }

    @GetMapping("/songs/{id}")
    public String getSongById(Model model, @PathVariable int id){

        String selSong = null;

        for (Song song : listSongs()) {
            if(song.getId() == id){
                selSong = "ID: " + song.getId() + " - " + " Title: " + song.getTitle();
            }

            if(selSong == null){
                selSong = "Song ID not found";
            }
        }

        model.addAttribute("song", selSong);

        return "songs";
    }

}
