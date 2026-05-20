import java.util.Random;
import java.util.Scanner;

class Song {

    private String title;
    private String artist;
    private String genre;

    public Song(String title, String artist, String genre) {
        this.title  = title;
        this.artist = artist;
        this.genre  = genre;
    }

    public String getTitle()  { return title;  }
    public String getArtist() { return artist; }
    public String getGenre()  { return genre;  }

    public String toString() {
        return title + " - " + artist + " [" + genre + "]";
    }
}


class Playlist {

    private Song[]  songs;
    private int     count;
    private String  name;

    public Playlist(String name, int capacity) {
        this.name  = name;
        this.songs = new Song[capacity];
        this.count = 0;
    }

    public void addSong(Song s) {
        if (count < songs.length) {
            songs[count] = s;
            count++;
            System.out.println("Added: " + s.getTitle());
        } else {
            System.out.println("Playlist is full!");
        }
    }

    public void removeSong(String title) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (songs[i].getTitle().equalsIgnoreCase(title)) {
                for (int j = i; j < count - 1; j++) {
                    songs[j] = songs[j + 1];
                }
                songs[count - 1] = null;
                count--;
                found = true;
                System.out.println("Removed: " + title);
                break;
            }
        }
        if (!found) {
            System.out.println("Song not found: " + title);
        }
    }

    public void searchSong(String keyword) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (songs[i].getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                songs[i].getArtist().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Found: " + songs[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No song found for: " + keyword);
        }
    }

    public void filterByGenre(String genre) {
        System.out.println("\nSongs in genre - " + genre + ":");
        boolean found = false;
        for (Song s : songs) {
            if (s == null) break;
            if (s.getGenre().equalsIgnoreCase(genre)) {
                System.out.println("  " + s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No songs found in genre: " + genre);
        }
    }

    public void shufflePlaylist() {
        if (count <= 1) {
            System.out.println("Not enough songs to shuffle.");
            return;
        }
        Random rand = new Random();
        for (int i = count - 1; i > 0; i--) {
            int j    = rand.nextInt(i + 1);
            Song tmp = songs[i];
            songs[i] = songs[j];
            songs[j] = tmp;
        }
        System.out.println("Playlist shuffled!");
    }

    public void displayPlaylist() {
        System.out.println("\nPlaylist: " + name);
        System.out.println("-------------------------");
        if (count == 0) {
            System.out.println("No songs in playlist.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + songs[i]);
            }
        }
        System.out.println("Total: " + count + " song(s)");
        System.out.println("-------------------------");
    }

    public String getName()  { return name;  }
    public int    getCount() { return count; }
}


public class MusicPlaylistSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Playlist playlist = new Playlist("My Playlist", 10);

        playlist.addSong(new Song("Believer",        "Imagine Dragons", "Rock"));
        playlist.addSong(new Song("Shape of You",    "Ed Sheeran",      "Pop"));
        playlist.addSong(new Song("Blinding Lights",  "The Weeknd",     "Pop"));
        playlist.addSong(new Song("Levitating",       "Dua Lipa",       "Pop"));
        playlist.addSong(new Song("Stressed Out",     "Twenty One Pilots","Indie"));

        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Music Playlist Menu =====");
            System.out.println("1. Display Playlist");
            System.out.println("2. Add Song");
            System.out.println("3. Remove Song");
            System.out.println("4. Search Song");
            System.out.println("5. Filter by Genre");
            System.out.println("6. Shuffle Playlist");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
                continue;
            }

            switch (choice) {

                case 1:
                    playlist.displayPlaylist();
                    break;

                case 2:
                    System.out.print("Enter title  : ");
                    String title = sc.nextLine().trim();
                    System.out.print("Enter artist : ");
                    String artist = sc.nextLine().trim();
                    System.out.print("Enter genre  : ");
                    String genre = sc.nextLine().trim();
                    playlist.addSong(new Song(title, artist, genre));
                    break;

                case 3:
                    System.out.print("Enter song title to remove: ");
                    String removeTitle = sc.nextLine().trim();
                    playlist.removeSong(removeTitle);
                    break;

                case 4:
                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine().trim();
                    playlist.searchSong(keyword);
                    break;

                case 5:
                    System.out.print("Enter genre to filter: ");
                    String filterGenre = sc.nextLine().trim();
                    playlist.filterByGenre(filterGenre);
                    break;

                case 6:
                    playlist.shufflePlaylist();
                    playlist.displayPlaylist();
                    break;

                case 7:
                    System.out.println("Exiting... Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Enter 1 to 7.");
            }
        }

        sc.close();
    }
}