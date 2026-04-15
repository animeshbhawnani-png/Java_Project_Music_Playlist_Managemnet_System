import java.util.Random;

class Song {
    private String title, artist;
    public Song(String title, String artist) { this.title = title; this.artist = artist; }
    public String getTitle()  { return title;  }
    public String getArtist() { return artist; }
}

class Playlist {
    private Song[] songs;
    private int count = 0;
    public Playlist(int size) { songs = new Song[size]; }

    public void addSong(Song s)      { if (count < songs.length) songs[count++] = s; }

    public void displayPlaylist() {
        for (int i = 0; i < count; i++)
            System.out.println((i + 1) + ". " + songs[i].getTitle() + " - " + songs[i].getArtist());
    }

    public void shufflePlaylist() {
        Random r = new Random();
        for (int i = count - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Song t = songs[i]; songs[i] = songs[j]; songs[j] = t;
        }
    }
}

public class MusicPlaylist {
    public static void main(String[] args) {
        Playlist p = new Playlist(5);
        p.addSong(new Song("Believer",        "Imagine Dragons"));
        p.addSong(new Song("Shape of You",    "Ed Sheeran"));
        p.addSong(new Song("Blinding Lights", "The Weeknd"));

        System.out.println("Playlist:");       p.displayPlaylist();
        p.shufflePlaylist();
        System.out.println("\nShuffled:");     p.displayPlaylist();
    }
}
