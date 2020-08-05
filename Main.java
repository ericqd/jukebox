/**
 * Author: Eric Dao
 * Date: 4/27/2020
 */
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        LinkedList linkedSongs = new LinkedList(); //creates new linkedlist of songs
        populateLinkedList(linkedSongs); // populates linkedlist with songs from song.txt
        boolean isTrue = false;
        while(isTrue == false){
            displayMenu(); //displays menu
            int selection = CheckInput.getIntRange(1,5); //user menu selection
            switch(selection){

            case 1: //option 1 
                addSong(linkedSongs); //Gets song data from user then adds to the end of linkedlist
                break;
            case 2:
                Song removed = linkedSongs.remove(0); // removes the first song in the linkedlist
                System.out.println(removed);
                break;
            case 3:
                displaySubMenu(); //display submenu
                int selection2 = CheckInput.getIntRange(1,3); //user submenu selection
                switch(selection2){
                    case 1:
                        titleArtistSearch(linkedSongs); //searches for first matching song by title and artist entered by user
                        break;
                    case 2:
                        artistSearch(linkedSongs); //searches for all songs by an artist and displays the songs
                        break;
                    case 3:
                        decadeSearch(linkedSongs); //searches for all songs in a certain decade then displays them
                        break;
                }
                break;
            case 4:
                displaySongs(linkedSongs); //displays all songs in the linked list
                break;
            case 5:
                isTrue = true; //exits out of loop
                writeToFile(linkedSongs); //writes songs in the linkedlist to songs.txt
                break;
            }
        }
    }
    /**
     * Functions
     */
    public static void displayMenu(){
        System.out.println("1. Add song");
        System.out.println("2. Play song");
        System.out.println("3. Search Song");
        System.out.println("4. Display songs");
        System.out.println("5. Quit");
    }
    public static void displaySubMenu(){
        System.out.println("1. Search by title and artist");
        System.out.println("2. Search by artist");
        System.out.println("3. Search by decade");
    }
    public static LinkedList populateLinkedList(LinkedList linkedlist){
        try{
            Scanner read = new Scanner(new File("songs.txt"));
            while(read.hasNext()){
                String line = read.nextLine(); //reads line in file
                String[] split = line.split(","); //splits words up separated by commas
                String title = split[0]; //stores first word in title
                String artist = split[1]; //stores second word in artist
                int year = Integer.parseInt(split[2]); //converts word 3 into an integer and stores in year
                int rating = Integer.parseInt(split[3]); //converts word 4 into an integer and stores in rating
                Song newSong = new Song(title,artist,year,rating); //creates a new song
                linkedlist.add(newSong); //adds song to linkedlist
            }
            read.close();
        } catch(FileNotFoundException fnf){
            System.out.println("File was not found");
        }
        return linkedlist;
    }
    public static void addSong(LinkedList linkedlist){
        System.out.print("Enter song name: ");
        String addName = CheckInput.getString();
        System.out.print("Enter song artist: ");
        String addArtist = CheckInput.getString();
        System.out.print("Enter song year: ");
        int addYear = CheckInput.getInt();
        System.out.print("Enter song rating (1-5): ");
        int addRating = CheckInput.getIntRange(1,5);
        Song userAddSong = new Song(addName,addArtist,addYear,addRating);
        linkedlist.add(userAddSong);
        linkedlist.sort();
    }
    public static void titleArtistSearch(LinkedList linkedlist){
        System.out.println("Enter title of song to search: ");
        String title = CheckInput.getString();
        System.out.println("Enter Artist of song to search: ");
        String artist = CheckInput.getString();
        Song searchSong = linkedlist.searchSong(title,artist);
        if(searchSong != null){
            System.out.println("Matched song: " + searchSong);
        }
        else{
            System.out.println("Not Found");
        }
    }
    public static void artistSearch(LinkedList linkedlist){
        System.out.println("Enter artist you would like to search: ");
        String testArtist = CheckInput.getString();
        ArrayList<Song> searchArtist = linkedlist.searchArtist(testArtist);
        if(searchArtist.isEmpty()){
            System.out.println("No matches found");
        }
        else{
            for(int i = 0; i < searchArtist.size(); i++){
                System.out.println("List of matches: " + searchArtist.get(i));
            }
        }
    }
    public static void decadeSearch(LinkedList linkedlist){
        System.out.println("Enter a decade (ex. 80's = 1980-1989 or 2000's = 2000-2009): ");
        String userDecade = CheckInput.getString();
        ArrayList<Song> searchDecade = linkedlist.searchDecade(userDecade);
        if(searchDecade.isEmpty()){
            System.out.println("No matches found");
        }
        else{
            for(int i = 0; i < searchDecade.size(); i++){
                System.out.println("List of matches in that decade: " + searchDecade.get(i));
            }
        }
    }
    public static void displaySongs(LinkedList linkedlist){
        System.out.println("Number of songs:" + linkedlist.size());
        linkedlist.display();
    }
    public static void writeToFile(LinkedList linkedlist){
        try{
            PrintWriter writer = new PrintWriter("songs.txt");
            writer.println(linkedlist.toString());
            writer.close();
        } catch(FileNotFoundException fnf){
            System.out.println("File was not found");
        }
    }
}