/**
 * Author: Eric Dao
 * Date: 4/27/2020
 */
public class Song {
    /**
     * Instance variables
     */
    private String title; // represents the title of the song
    private String artist; // represents the artist of the son
    private int year; //represents the year song was released
    private int rating; //represents the rating of the song
    /**
     * Default Constructor
     * Sets year and rating to 0 and title and artist with empty strings
     */
    public Song(){
        year = 0;
        rating = 0;
        title = "";
        artist = "";
    }
    /** 
     * Constructor
     * @param t title
     * @param a artist
    */
    public Song(String t, String a){
        year = 0;
        rating = 0;
        title = t;
        artist = a;
    }
    /**
     * Constructor
     * @param t title
     * @param a artist
     * @param y year 
     * @param r rating
     */
    public Song(String t, String a, int y, int r){
        this.title = t;
        this.artist = a;
        this.year = y;
        this.rating = r;
    }
    /**
     * Retrieves the value of title
     * @return title
     */
    public String getTitle(){
        return title;
    }
    /**
     * Retrieves the value of artist
     * @return artist
     */
    public String getArtist(){
        return artist;
    }
    /**
     * Retrieves the value of year
     * @return year
     */
    public int getYear(){
        return year;
    }
    /**
     * Retrieves the value of rating
     * @return rating
     */
    public int getRating(){
        return rating;
    }
    /** The string representation of song
     * @return string representation of song
     */
    @Override
    public String toString(){
        return(title + "," + artist + "," + year + "," + rating);
    }
    /**
     * Compares two songs to see if they are equal
     * @param song
     * @return true if equal, false if not
     */
    public boolean equals(Object song){
        if(song instanceof Song){
            Song s2 = (Song) song;
            if(title.equalsIgnoreCase(s2.title) && artist.equalsIgnoreCase(s2.artist)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
   }
    /**
     * Compares two songs to determine order
     * @param other other song being compared
     * @return val
     */
    public int compareTo(Song other){
        if(this.getRating() == other.getRating()){
            int val = this.getArtist().compareTo(other.getArtist());
            if(val == 0){
                return this.getTitle().compareTo(other.getTitle());
            }
            else{
                return val;
            }
        }
        else{
            return(this.getRating() - other.getRating());
        }
    }
}