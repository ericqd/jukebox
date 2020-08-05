/**
 * Author: Eric Dao
 * Date: 4/27/2020
 */
import java.util.ArrayList;
public class LinkedList {
    private static class Node{
        /**
         * Instance variables
         */
        private Song data; //represents the data of node
        private Node next; //represents the next node
        /**
         * Constructor
         * Sets data to s and next to null
         * @param s song
         */
        public Node(Song s){
            data = s;
            next = null;
        }
        /**
         * Constructor
         * @param s song
         * @param n node
         */
        public Node(Song s, Node n){
            data = s;
            next = n;
        }
    }
    /**
     * Instance variables
     */
    private Node first; //represents the first node
    private Node last; //represents the last node
    /**
     * Default Constructor
     * Sets first and last to null
     */
    public LinkedList(){
        first = null;
        last = null;
    }
    /**
     * Checks to see if linked list is empty
     * @return true if first is null false if not
     */
    public boolean isEmpty(){
        return first == null;
    }
    /**
     * Adds a new song object to the end of the linkedlist
     * @param s song
     */
    public void add(Song s){
        if(first == null){
            first = new Node(s); // if list is empty adds a new node
            last = first;
        }
        else{
            Node n = new Node(s); // creates new node
            last.next = n; // dereferences last node
            last = n;
        }
    }
    /**
     * Finds the amount of elements in the linked list
     * @return count
     */
    public int size(){
        int count = 0;
        Node n = first;
        while(n != null){
            count ++;
            n = n.next;
        }
        return count;
    }
    /**
     * Removes the first song in the linkedlist
     * @param i
     * @return rem
     */
    public Song remove(int i){
        Song rem = new Song("","",0,0);
        if(i == 0){
            rem = first.data; 
            first = first.next;
            if(first == null){
                last = null;
            }
        }
        return rem;
    }
    /**
     * Iterates through the linked list until it finds a song matching the title and artist
     * @param title
     * @param artist
     * @return current.data if it finds a match, null if it doesnt
     */
    public Song searchSong(String title, String artist){
        Song newSong = new Song(title,artist); //creates new song
        Node current = first;
        while(current != null){
            if(newSong.equals(current.data)){ // if newsong is equal to song data in linked list
                return (Song) current.data;
            }
            current = current.next; //iterates to next node
        }
        return null;
    }
    /**
     * Iterates through the linkedlist and adds songs by the same artist into an Arraylist
     * @param artist
     * @return matchingArtist
     */
    public ArrayList<Song> searchArtist(String artist){
        ArrayList<Song> matchingArtist = new ArrayList<Song>();
        Node current = first;
        while(current != null){
            if(current.data.getArtist().equalsIgnoreCase(artist)){ //artist in linked list is equal to the artist of the user
                matchingArtist.add(current.data); //add to arraylist
            }
            current = current.next; //iterates to next node
        }
        return matchingArtist; 
    }
    /**
     * Iterates through linkedlist and adds songs of the same decade to an arraylist
     * @param decade
     * @return matchingDecade
     */
    public ArrayList<Song> searchDecade(String decade){
        ArrayList<Song> matchingDecade = new ArrayList<Song>();
        Node current = first;
        while(current != null){
            if(decade.equals("30's") || decade.equals("1930's")){
                if(current.data.getYear() == 1930 || current.data.getYear() == 1931 || current.data.getYear() == 1932 || current.data.getYear() == 1933 || current.data.getYear() == 1934 || current.data.getYear() == 1935  || current.data.getYear() == 1936 || current.data.getYear() == 1937 || current.data.getYear() == 1938 ||current.data.getYear() == 1939){
                    matchingDecade.add(current.data);
                }
            }
            else if(decade.equals("40's") || decade.equals("1940's")){
                if(current.data.getYear() == 1940 || current.data.getYear() == 1941 || current.data.getYear() == 1942 || current.data.getYear() == 1943 || current.data.getYear() == 1944 || current.data.getYear() == 1945  || current.data.getYear() == 1946 || current.data.getYear() == 1947 || current.data.getYear() == 1948 ||current.data.getYear() == 1949){
                    matchingDecade.add(current.data);
                }
            }
            else if(decade.equals("50's") || decade.equals("1950's")){
                if(current.data.getYear() == 1950 || current.data.getYear() == 1951 || current.data.getYear() == 1952 || current.data.getYear() == 1953 || current.data.getYear() == 1954 || current.data.getYear() == 1955  || current.data.getYear() == 1956 || current.data.getYear() == 1957 || current.data.getYear() == 1958 ||current.data.getYear() == 1959){
                    matchingDecade.add(current.data);
                }
            }
            else if(decade.equals("60's") || decade.equals("1960's")){
                if(current.data.getYear() == 1960 || current.data.getYear() == 1961 || current.data.getYear() == 1962 || current.data.getYear() == 1963 || current.data.getYear() == 1964 || current.data.getYear() == 1965  || current.data.getYear() == 1966 || current.data.getYear() == 1967 || current.data.getYear() == 1968 ||current.data.getYear() == 1969){
                    matchingDecade.add(current.data);
                }
            }
            else if(decade.equals("70's") || decade.equals("1970's")){
                if(current.data.getYear() == 1970 || current.data.getYear() == 1971 || current.data.getYear() == 1972 || current.data.getYear() == 1973 || current.data.getYear() == 1974 || current.data.getYear() == 1975  || current.data.getYear() == 1976 || current.data.getYear() == 1977 || current.data.getYear() == 1978 ||current.data.getYear() == 1979){
                    matchingDecade.add(current.data);
                }
            }
            else if(decade.equals("80's") || decade.equals("1980's")){
                if(current.data.getYear() == 1980 || current.data.getYear() == 1981 || current.data.getYear() == 1982 || current.data.getYear() == 1983 || current.data.getYear() == 1984 || current.data.getYear() == 1985  || current.data.getYear() == 1986 || current.data.getYear() == 1987 || current.data.getYear() == 1988 ||current.data.getYear() == 1989){
                    matchingDecade.add(current.data);
                }
            }
            else if(decade.equals("90's") || decade.equals("1990's")){
                if(current.data.getYear() == 1990 || current.data.getYear() == 1991 || current.data.getYear() == 1992 || current.data.getYear() == 1993 || current.data.getYear() == 1994 || current.data.getYear() == 1995  || current.data.getYear() == 1996 || current.data.getYear() == 1997 || current.data.getYear() == 1998 ||current.data.getYear() == 1999){
                    matchingDecade.add(current.data);
                }
            }
            else if(decade.equals("2000's")){
                if(current.data.getYear() == 2000 || current.data.getYear() == 2001 || current.data.getYear() == 2002 || current.data.getYear() == 2003 || current.data.getYear() == 2004 || current.data.getYear() == 2005  || current.data.getYear() == 2006 || current.data.getYear() == 2007 || current.data.getYear() == 2008 ||current.data.getYear() == 2009){
                    matchingDecade.add(current.data);
                }
            }
            else if(decade.equals("2010's")){
                if(current.data.getYear() == 2010 || current.data.getYear() == 2011 || current.data.getYear() == 2012 || current.data.getYear() == 2013 || current.data.getYear() == 2014 || current.data.getYear() == 2015  || current.data.getYear() == 2016 || current.data.getYear() == 2017 || current.data.getYear() == 2018 ||current.data.getYear() == 2019){
                    matchingDecade.add(current.data);
                }
            }
            else if(decade.equals("2020's")){
                if(current.data.getYear() == 2020){
                    matchingDecade.add(current.data);
                }
            }
            current = current.next;
        }
        return matchingDecade;
    }
    /**
     * Sorts linked list using bubble sort
     */
    public void sort(){
        Node current = first;
        while(current != null){
            Node second = current.next;
            while(second != null){
                if(current.data.compareTo(second.data) < 0){ //if comparison value is negative
                    Song temp = current.data;
                    current.data = second.data; //swaps values
                    second.data = temp;
                }
                second = second.next; //iterates next node of second
            }
            current = current.next; // iterates to next next of current
        }
    }
    /**
     * Displays each song in the linked list
     */
    public void display(){
        Node current = first;
        if(current== null){
            System.out.println("List is empty");
        }
        while(current != null){
            System.out.println(current.data + " "); //if linked list is not empty print out song data
            current = current.next; //iterates to next node
        }
        System.out.println();
    }
    /**
     * Returns the linkedlist of songs as a string to read/write onto a file
     */
    @Override
    public String toString(){
        String str = ""; //empty string
        Node current = first;  
        while( current != null){
            str = str + current.data + "\n"; //adds song data to empty string with a newline
            current = current.next;
        }
        return str;

    }
}