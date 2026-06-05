import java.util.Random;

// ============================================================
// Song Class
// Represents a single song with title and artist.
// Demonstrates Encapsulation.
// ============================================================
class Song {
    private String title;
    private String artist;

    // Constructor to initialize song details
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Getter method for title
    public String getTitle() {
        return title;
    }

    // Getter method for artist
    public String getArtist() {
        return artist;
    }

    // Returns song details in readable format
    @Override
    public String toString() {
        return title + " - " + artist;
    }
}

// ============================================================
// Playlist Class
// Demonstrates Aggregation (HAS-A relationship)
// Playlist HAS-A collection of Song objects.
// ============================================================
class Playlist {
    private Song[] songs; // Array of Song objects
    private int count;    // Number of songs currently in playlist

    // Constructor
    public Playlist(int size) {
        songs = new Song[size];
        count = 0;
    }

    // Adds a song to the playlist
    public void addSong(Song s) {
        if (count < songs.length) {
            songs[count] = s;
            count++;
            System.out.println("Song added successfully.");
        } else {
            System.out.println("Playlist is full.");
        }
    }

    // Displays all songs using an enhanced for-loop
    public void displayPlaylist() {
        if (count == 0) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("\nPlaylist:");

        int number = 1;

        for (Song song : songs) {
            if (song != null) {
                System.out.println(number + ". " + song);
                number++;
            }
        }
    }

    // Fisher-Yates Shuffle Algorithm
    // Randomly rearranges songs in the playlist
    public void shufflePlaylist() {
        Random random = new Random();

        for (int i = count - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            Song temp = songs[i];
            songs[i] = songs[j];
            songs[j] = temp;
        }

        System.out.println("\nShuffling Playlist...");
    }
}

// ============================================================
// Main Class
// Tests playlist creation, song addition, display,
// and shuffle functionality.
// ============================================================
public class MusicApp {

    public static void main(String[] args) {

        // Create playlist with capacity 10
        Playlist playlist = new Playlist(10);

        // Add songs
        playlist.addSong(new Song("Believer", "Imagine Dragons"));
        playlist.addSong(new Song("Shape of You", "Ed Sheeran"));
        playlist.addSong(new Song("Blinding Lights", "The Weeknd"));

        // Display original playlist
        System.out.println("\nOriginal Playlist");
        playlist.displayPlaylist();

        // Shuffle playlist
        playlist.shufflePlaylist();

        // Display shuffled playlist
        System.out.println("\nShuffled Playlist");
        playlist.displayPlaylist();
    }
}