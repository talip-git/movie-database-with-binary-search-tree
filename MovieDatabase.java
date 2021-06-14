import java.util.PriorityQueue;

public class MovieDatabase {
    //Movie database class


    //Movie tree
    private final MovieTree movieTree = new MovieTree();

    public void addMovie(String movie_title,String dfirstName,String dlastName,int releaseDay,int releaseMonth,int release_year){
        //--------------------------------------------------------
        // Summary: Adds a movie to the Bst by traversing the tree
        // Precondition: this function takes the root movie and other fields for adding the movie to the tree
        // Postcondition: The movie is added to the set
        //--------------------------------------------------------
        //movieTree.addMovie(movie_title,dfirstName,dlastName,releaseDay,releaseMonth,release_year);
        movieTree.addMovie(movie_title,dfirstName,dlastName,releaseDay,releaseMonth,release_year);
    }
    public void removeMovie(String movieTitle){
        movieTree.removeMovie(movieTitle);
    }
    public void addActor(String movieTitle,String actorFirstName,String actorLastName,String actorRole){
        //--------------------------------------------------------
        // Summary: Adds the new actor to the linked list of the movie
        // Precondition: movie title, actor first name lastName and role are strings and they can not be null
        // Postcondition: actor is added to the movie
        //--------------------------------------------------------
        movieTree.addActor(movieTitle,actorFirstName,actorLastName,actorRole);
    }
    public void removeActor(String movieTitle,String actorFirstName,String actorLastName){
        //--------------------------------------------------------
        // Summary: Removes the actor from the movie
        // Precondition: movie title, actor first name lastName and role are strings and they can not be null
        // Postcondition: actor is added to the movie
        //--------------------------------------------------------
        movieTree.removeActor(movieTitle,actorFirstName,actorLastName);
    }
    public void showAllMovies(){
        //--------------------------------------------------------
        // Summary: Shows all the movies by traversing through the three. Calls the iterator with queue
        // Precondition:
        // Postcondition: All the movies are printed to the screen. If they are none, than it prints --none--
        //--------------------------------------------------------
        movieTree.showAllMovies();
    }
    public void showMovie(String movieTitle){
        //--------------------------------------------------------
        // Summary: Shows the specific movie to the screen
        // Precondition: movie title is a string
        // Postcondition: The movie is printed to the screen,if the check movie returns false than it does not exists
        //--------------------------------------------------------
        movieTree.showMovie(movieTitle);
    }
    public void showActorRoles(String actorFirstName,String actorLastName){
        //--------------------------------------------------------
        // Summary: Shows the roles of the actors who are in the movie database
        // Precondition: first name and last names are strings, and they can not be null
        // Postcondition: The movie is printed to the screen,if the check movie returns false than it does not exists
        //--------------------------------------------------------
        System.out.println(movieTree.showActorRoles(actorFirstName,actorLastName));
    }
    public void showDirectorMovies(String directorFirstName, String directorLastName ){
        //--------------------------------------------------------
        // Summary: Shows the directors and the movies that they direct in descending order
        // Precondition: first name and last names are strings, and they can not be null
        // Postcondition: Directors are printed to the screen, if director does not exists than print none
        //--------------------------------------------------------
        String directorName = directorFirstName+" "+directorLastName;
        System.out.println(movieTree.showDirectorMovies(directorFirstName,directorLastName));
    }
    public void showMovies( int releaseYear ) {
        //--------------------------------------------------------
        // Summary: Shows the movies according to the year
        // Precondition: release year is a integer
        // Postcondition: Directors are printed to the screen, if director does not exists than print none
        //--------------------------------------------------------
        System.out.println(movieTree.showMovies(releaseYear));
    }
    public void showMovies( int startYear, int endYear ){
        //--------------------------------------------------------
        // Summary: Shows the movies according to the year
        // Precondition: start year and end years are integers
        // Postcondition: Movies that are in these years printed to the screen
        //--------------------------------------------------------
        System.out.println(movieTree.showMovies(startYear,endYear));
    }
    public Movie returnMovie(String movieTitle) {
        // --------------------------------------------------------
        // Summary: Finds the given movie's node recursively and return its data.
        // Precondition: Given movie member should exists.
        // Postcondition: Wanted node is returned if it exists. Otherwise, returned null
        // --------------------------------------------------------
        return movieTree.returnMovie(movieTitle);
    }
}
