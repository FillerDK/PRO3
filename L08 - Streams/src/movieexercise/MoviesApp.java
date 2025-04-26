package movieexercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoviesApp {
    public static List<Movie> readMovies(String filename) throws IOException {
        List<Movie> movies = new ArrayList<>();
        try (Scanner in = new Scanner(new File(filename))) {
            while (in.hasNextLine()) {
                String nameLine = in.nextLine();
                String yearLine = in.nextLine();
                String directorsLine = in.nextLine();
                String producersLine = in.nextLine();
                String actorsLine = in.nextLine();
                movies.add(new Movie(getString(nameLine),
                        Integer.parseInt(getString(yearLine)),
                        getList(directorsLine), getList(producersLine),
                        getList(actorsLine)));
            }
        }
        return movies;
    }

    private static String getString(String line) {
        int colon = line.indexOf(":");
        return line.substring(colon + 1).trim();
    }

    private static List<String> getList(String line) {
        return Stream.of(getString(line).split(", "))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        List<Movie> movieList = readMovies("movies.txt");
//        for (Movie m : movieList) {
//            System.out.println(m.getTitle());
//        }

        //movieList.stream().forEach(e -> System.out.println(e.getTitle()));
        System.out.println("Number of movies: " + movieList.size());

        //  The number of movies starting with "H"
        // TODO Opgave
        long count = movieList.stream()
                .filter(m -> m.getTitle().toLowerCase().startsWith("h"))
                .count();
        System.out.println("Number of movies starting with H: " + count);

        // The title of the movies starting with "X"
        // TODO Opgave
        System.out.println("Number of movies starting with X: " + movieList.stream()
                .filter(m -> m.getTitle().toLowerCase().startsWith("x"))
                .collect(Collectors.toList()));

        // The number of films where the director is also an actor
        // TODO Opgave
        count = movieList.stream()
            .filter(m -> m.getDirectors().stream()
                    .anyMatch(d -> m.getActors().contains(d)))
            .count();
        System.out.println("Number of movies where the director is also an actor: " + count);

        //The number of actors in the film with the most actors
        // TODO Opgave
        int maxActors = movieList.stream()
                .mapToInt(m -> m.getActors().size())
                .max()
                .orElse(0);
        System.out.println("Max actors in a movie: " + maxActors);

        // The title of the film with the most actors
        // TODO Opgave
        String title = movieList.stream()
                .filter(m -> m.getActors().size() == maxActors)
                .map(Movie::getTitle)
                .findFirst()
                .orElse("No title found");
        System.out.println("Title of the movie with the most actors: " + title);

        //Number of films divided by first letter in the film title
        // TODO Opgave
        Map<String, Long> countByFirstLetter = movieList.stream()
                .collect(Collectors.groupingBy(m -> m.getTitle().substring(0, 1).toUpperCase(), Collectors.counting()));
        System.out.println("Number of movies by first letter: " + countByFirstLetter);

        // Number of movies whose title starts with "The "
        // TODO Opgave

        long countThe = movieList.stream()
                .filter(m -> m.getTitle().toLowerCase().startsWith("the "))
                .count();
        System.out.println("Number of movies starting with The: " + countThe);
    }

}

