import java.util.LinkedList;

public class Movie implements Comparable<Movie> {
    public String movie_title;
    public String director_firstName;
    public String director_lastName;
    public int day;
    public int month;
    public int year;

    private final CastTree castTree = new CastTree();
    public int count = 0;

    public Movie left,right;
    //Constructor for the movie class
    public Movie(String movie_title, String director_firstName,String director_lastName, int day, int month, int year) {
        this.movie_title = movie_title;
        this.director_firstName = director_firstName;
        this.director_lastName = director_lastName;
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public Movie(String movie_title, String director_firstName,String director_lastName, int day, int month, int year,int count) {
        this.movie_title = movie_title;
        this.director_firstName = director_firstName;
        this.director_lastName = director_lastName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.count = count;
    }
    public void removeActor(String actorFirstName,String actorLastName){
        //--------------------------------------------------------
        // Summary: removes actor from the cast according to the firstName and lastName
        // Precondition: firstName and lastName are strings
        // Postcondition:actor had been removed from the cast
        //--------------------------------------------------------
       castTree.removeActor(actorFirstName,actorLastName);
    }
    public void addActor(String actorFirstName,String actorLastName,String actorRole){
        //--------------------------------------------------------
        // Summary: adds actor to the cast according to the firstName and lastName
        // Precondition: firstName, lastName and actorRole are strings
        // Postcondition:actor had been added to the cast
        //--------------------------------------------------------
        castTree.addActor(actorFirstName,actorLastName,actorRole);
    }
    public boolean checkActor(String actorFirstName,String actorLastName,String actorRole){
        //--------------------------------------------------------
        // Summary: checks whether actor exists in the cast
        // Precondition: firstName, lastName and actorRole are strings
        // Postcondition: condition returned
        //--------------------------------------------------------
        Actor actor = castTree.returnActor(actorFirstName,actorLastName);
        if (actor == null){
            return false;
        }
        return true;
    }
    public Actor returnActor(String actorFirstName,String actorLastName){
        //--------------------------------------------------------
        // Summary: returns the actor according to the firstName and LastName
        // Precondition: firstName, lastName are strings
        // Postcondition: actor returned
        //--------------------------------------------------------
        Actor actor;
        actor = castTree.returnActor(actorFirstName,actorLastName);
        if (actor == null){
            return null;
        }
        return actor;
    }
    @Override
    public int compareTo(Movie o) {
        //--------------------------------------------------------
        // Summary: comapres two movies according to titles
        // Precondition:
        // Postcondition: int returned
        //--------------------------------------------------------
        if (movie_title.compareTo(o.getMovie_title())>0)
            return 1;
        if (movie_title.compareTo(o.getMovie_title())<0)
            return -1;
        else
            return 0;
    }
    public int returnKey(){
        //--------------------------------------------------------
        //Returns they year key
        //--------------------------------------------------------
        return year+month+day;
    }
    public String getDirectorName(){
        return director_firstName+" "+director_lastName;
    }
    @Override
    public String toString() {
        return getMovie_title()+", "+getYear()+", "+getDirector_firstName()+ " "+getDirector_firstName();
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Movie getLeft() {
        return left;
    }

    public void setLeft(Movie left) {
        this.left = left;
    }

    public Movie getRight() {
        return right;
    }

    public void setRight(Movie right) {
        this.right = right;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getDirector_firstName() {
        return director_firstName;
    }

    public void setDirector_firstName(String director_firstName) {
        this.director_firstName = director_firstName;
    }

    public String getDirector_lastName() {
        return director_lastName;
    }

    public void setDirector_lastName(String director_lastName) {
        this.director_lastName = director_lastName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
