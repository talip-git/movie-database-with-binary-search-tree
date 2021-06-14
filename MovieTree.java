import java.util.PriorityQueue;

public class MovieTree {
    //Movie tree root node
    private Movie root = null;

    public void addMovie(String movie_title,String dfirstName,String dlastName,int releaseDay,int releaseMonth,int release_year){
        root = addMovie(root,movie_title,dfirstName,dlastName,releaseDay,releaseMonth,release_year);
        System.out.println("INFO: Movie "+movie_title+" has been added");
    }
    private Movie addMovie(Movie root,String movie_title,String dfirstName,String dlastName,int releaseDay,int releaseMonth,int release_year){
        //--------------------------------------------------------
        // Summary: Adds a movie to the Bst by traversing the tree
        // Precondition: this function takes the root movie and other fields for adding the movie to the tree
        // Postcondition: The movie is added to the set
        //--------------------------------------------------------
        if (checkMovie(movie_title)){

        }
        else{
            if (root == null){
                return root = new Movie(movie_title,dfirstName,dlastName,releaseDay,releaseMonth,release_year);
            }
            if (root.getYear() <= release_year) {
                root.right = addMovie(root.right,movie_title,dfirstName,dlastName,releaseDay,releaseMonth,release_year);
            }
            else if(root.getYear()>release_year){
                root.left = addMovie(root.left,movie_title,dfirstName,dlastName,releaseDay,releaseMonth,release_year);
            }
            else{
                root.setMovie_title(movie_title);
            }
            root.count = (1 + size(root.left) + size(root.right));
        }
        return root;
    }
    public void removeMovie(String movieTitle){
        //--------------------------------------------------------
        // Summary: Removes the actor from the movie
        // Precondition: movie title, actor first name lastName and role are strings and they can not be null
        // Postcondition: actor is added to the movie
        //--------------------------------------------------------
        Movie movie = returnMovie(movieTitle);
        if (movie == null) {
            return;
        }
        removeMovie(root,movieTitle);
        System.out.printf("INFO: Movie %s has been removed", movieTitle);
    }
    private Movie removeMovie(Movie root,String movieTitle) {
        //--------------------------------------------------------
        // Summary: removes the movie from the tree
        // Precondition: this function takes the root movie and the movie title for us to remove the movie
        // Postcondition: movie is removed from the tree
        //--------------------------------------------------------
        if (root == null) return null;
        int cmp = movieTitle.compareTo(root.getMovie_title());
        if (cmp < 0)
            root.setLeft(removeMovie(root.getLeft(), movieTitle));
        else if (cmp > 0)
            root.setRight(removeMovie(root.getRight(),movieTitle));
        else {
            if (root.getRight() == null)
                return root.getLeft();
            if (root.getLeft() == null)
                return root.getRight();
            Movie tmp = root;
            root = min(tmp.getRight());
            root.setRight(deleteMin(tmp.getRight()));
            root.setLeft(tmp.getLeft());
        }
        root.setCount(size(root.getLeft()) + size(root.getRight()) + 1);
        return root;
    }

    public void addActor(String movieTitle,String actorFirstName,String actorLastName,String actorRole){
        //--------------------------------------------------------
        // Summary: Adds the new actor to the linked list of the movie
        // Precondition: movie title, actor first name lastName and role are strings and they can not be null
        // Postcondition: actor is added to the movie
        //--------------------------------------------------------
        Movie movie = returnMovie(movieTitle);
        if (movie ==null){
        }
        else{
            movie.addActor(actorFirstName,actorLastName,actorRole);
            System.out.printf("INFO:Actor %s %s %s has been added to the movie: %s.\n",actorFirstName,actorFirstName,actorRole,movieTitle);
        }
    }


    public void removeActor(String movieTitle,String actorFirstName,String actorLastName){
        //--------------------------------------------------------
        // Summary: Removes the actor from the movie
        // Precondition: movie title, actor first name lastName and role are strings and they can not be null
        // Postcondition: actor is added to the movie
        //--------------------------------------------------------
        Movie movie = returnMovie(movieTitle);
        if (movie ==null){
            System.out.printf("Err: Movie %s does not exists!\n",movieTitle);
        }
        else{
            movie.removeActor(actorFirstName,actorLastName);
            System.out.printf("INFO:Actor %s %s  has been removed from the movie: %s.\n",actorFirstName,actorLastName,movieTitle);
        }
    }


    public void showAllMovies(){
        //--------------------------------------------------------
        // Summary: Shows all the movies by traversing through the three. Calls the iterator with queue
        // Precondition:
        // Postcondition: All the movies are printed to the screen. If they are none, than it prints --none--
        //--------------------------------------------------------
        System.out.println(displayByRelase());
    }


    public void showMovie(String movieTitle){
        //--------------------------------------------------------
        // Summary: Shows the specific movie to the screen
        // Precondition: movie title is a string
        // Postcondition: The movie is printed to the screen,if the check movie returns false than it does not exists
        //--------------------------------------------------------
        Movie movie = returnMovie(movieTitle);
        if(movie == null){
            System.out.println("Movie does not exists!-");
            return;
        }
        System.out.println(movie.getMovie_title());
        System.out.println(movie.getDay()+"/"+movie.getMonth()+"/"+movie.getYear());
        System.out.println(movie.getDirector_firstName()+" "+movie.getDirector_lastName());

    }


    public String showActorRoles(String actorFirstName,String actorLastName){
        return showActorRoles(root,actorFirstName,actorLastName);
    }
    private String showActorRoles(Movie root,String actorFirstName,String actorLastName ){
        //--------------------------------------------------------
        // Summary: Shows the roles of the actors who are in the movie database
        // Precondition: first name and last names are strings, and they can not be null
        // Postcondition: The movie is printed to the screen,if the check movie returns false than it does not exists
        //--------------------------------------------------------
        if (root == null) {
            return "";
        }
        Actor actor = root.returnActor(actorFirstName,actorLastName);
        String output = "";
        if (actor != null) {
            output += String.format("%s, %s, %d\n", actor.getRole(), root.getMovie_title(),root.getYear());
        }
        return showActorRoles(root.right, actorFirstName,actorLastName) + output + showActorRoles(root.left, actorFirstName,actorLastName);
    }


    public String showDirectorMovies(String directorFirstName, String directorLastName ){
        return showDirectorMovies(root,directorFirstName,directorLastName);
    }
    private String showDirectorMovies(Movie root,String directorFirstName, String directorLastName ){
        //--------------------------------------------------------
        // Summary: Shows the directors and the movies that they direct in descending order
        // Precondition: first name and last names are strings, and they can not be null
        // Postcondition: Directors are printed to the screen, if director does not exists than print none
        //--------------------------------------------------------
        if (root == null) {
            return "";
        }
        String returnString = "";

        if (root.getDirectorName().equals(directorFirstName+" "+directorLastName)) {
            Movie movie = root;
            returnString += String.format(" %s, %d/%d/%d\n",movie.getMovie_title(), movie.getDay(),movie.getMonth(), movie.getYear());
        }
        return showDirectorMovies(root.right, directorFirstName,directorLastName) + returnString + showDirectorMovies(root.left, directorFirstName,directorLastName);
    }


    public String showMovies(int releaseYear) {
        return showMovies(root, releaseYear);
    }
    public String showMovies(Movie root,int releaseYear ) {
        //--------------------------------------------------------
        // Summary: Shows the movies according to the year
        // Precondition: release year is a integer
        // Postcondition: Directors are printed to the screen, if director does not exists than print none
        //--------------------------------------------------------
        if (root == null) {
            return "";
        }
        String toString = "";
        Movie movie;
        if (releaseYear == root.getYear()) {
            movie = root;
            toString += String.format("%s, %s, %d/%d\n", movie.getMovie_title(),movie.getDirectorName(), movie.getDay(), movie.getMonth());
            return showMovies(root.right, releaseYear) + toString;
        }
        if (releaseYear > root.getYear()) {
            return showMovies(root.right, releaseYear);
        }
        return showMovies(root.left, releaseYear);
    }


    public String showMovies(int startYear, int endYear) {
        return this.showMovies(root, startYear, endYear);
    }
    public String showMovies(Movie root,int startYear, int endYear ){
        //--------------------------------------------------------
        // Summary: Shows the movies according to the year
        // Precondition: start year and end years are integers
        // Postcondition: Movies that are in these years printed to the screen
        //--------------------------------------------------------
        String s = "";
        if (root == null) {
            return "";
        }
        int releaseYear = root.getYear();

        if (releaseYear >= startYear && releaseYear <= endYear) {

            Movie movie = root;
            s += String.format("Movie %s, %s, %d\n", movie.getMovie_title(), movie.getDirectorName(),movie.getYear());
        }
        return showMovies(root.right, startYear, endYear) + s + showMovies(root.left, startYear, endYear);
    }
    private int size(Movie root)
    {
        //--------------------------------------------------------
        // Summary: returns the size the movie tree
        // Precondition: root is a Movie object
        // Postcondition: the size is returned
        //--------------------------------------------------------
        if (root == null) return 0;
        return root.getCount();
    }
    private Boolean checkMovie(String title){
        //--------------------------------------------------------
        // Summary: check whether the movie exists or not, if exist than return true, else false
        // Precondition: title is the title of the movie and its a string
        // Postcondition: the size is returned
        //--------------------------------------------------------
        Movie movie = returnMovie(title);
        if (movie !=null){
            return true;
        }
        return false;
    }
    public Movie returnMovie(String movieTitle) {
        return returnMovie(root, movieTitle);
    }

    private Movie returnMovie(Movie root, String movieTitle) {
        // --------------------------------------------------------
        // Summary: Finds the given movie's node recursively and return its data.
        // Precondition: Given movie member should exists.
        // Postcondition: Wanted node is returned if it exists. Otherwise, returned null
        // --------------------------------------------------------
        if (root == null) {
            return null;
        }
        Movie left = null;
        Movie right = null;
        if (root.getMovie_title().equals(movieTitle)) {
            return root;
        }
        if (root.right != null) {
            right = returnMovie(root.right, movieTitle);
        }
        if (root.left != null) {
            left = returnMovie(root.left, movieTitle);
        }
        if (left != null)
            return left;
        else if (right != null)
            return right;

        return null;
    }
    private Movie min(Movie root) {
        //--------------------------------------------------------
        // Summary: returns the min movie
        // Precondition: root is a movie
        // Postcondition:min movie is returned
        //--------------------------------------------------------
        if (root.getLeft() == null)
            return root;
        else
            return min(root.getLeft());
    }
    private Movie deleteMin(Movie root) {
        //--------------------------------------------------------
        // Summary: deletes the the min movie, uses min function
        // Precondition: root is a movie
        // Postcondition:min movie is deleted
        //--------------------------------------------------------
        if (root.getLeft() == null)
            return root.getRight();
        root.left = (deleteMin(root.left));
        root.setCount(size(root.getLeft()) + size(root.getRight()) + 1);
        return root;
    }
    public String displayByRelase() {

        return displayByRelase(root);
    }
    private String displayByRelase(Movie root) {
        // --------------------------------------------------------
        // Summary: Prints all movies in ascending form with respect to their release years
        // Precondition:
        // Postcondition: Movies are printed.
        // --------------------------------------------------------
        if (root == null) {
            return "";
        }
        String data = String.format("%s, %d, %s %s", root.getMovie_title(), root.getYear(),root.getDirector_firstName(),root.getDirector_lastName());
        return displayByRelase(root.left) + "\n" + data + displayByRelase(root.right);

    }
}
