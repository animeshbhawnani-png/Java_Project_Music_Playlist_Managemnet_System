// ============================================================
//  MusicApp.java
//  Contains the Playlist class AND the main() method.
//
//  OOP Concepts demonstrated:
//    • Aggregation   – Playlist HAS-A Song[]  (HAS-A relationship)
//    • Encapsulation – private fields, public methods
//    • Arrays of objects
//    • Fisher-Yates shuffle (randomisation logic)
//    • Enhanced for-loop (for-each) traversal
// ============================================================

import java.util.Random;   // needed for Random class used in shuffle

public class MusicApp {

    // ============================================================
    //  INNER CLASS: Playlist
    //  Manages a fixed-size collection of Song objects.
    // ============================================================
    static class Playlist {

        // ── Fields ────────────────────────────────────────────
        private Song[] songs;   // array that stores Song objects  (aggregation)
        private int count;      // how many songs have been added so far

        // ── Constructor ───────────────────────────────────────
        /**
         * Creates an empty playlist that can hold up to maxSize songs.
         *
         * @param maxSize maximum number of songs allowed
         */
        public Playlist(int maxSize) {
            songs = new Song[maxSize];  // allocate array of Song references
            count = 0;                  // no songs added yet
        }

        // ── Method 1: addSong() ───────────────────────────────
        /**
         * Adds a Song to the playlist if there is space.
         *
         * @param s the Song object to add
         */
        public void addSong(Song s) {
            if (count >= songs.length) {
                // Playlist is full – cannot add more songs
                System.out.println("Playlist is full! Cannot add: " + s.getTitle());
            } else {
                songs[count] = s;   // store the Song at the next free slot
                count++;            // move the counter forward
            }
        }

        // ── Method 2: displayQueue() ─────────────────────────
        /**
         * Prints all songs currently in the playlist using an
         * enhanced for-loop (for-each loop).
         */
        public void displayQueue() {
            int number = 1;

            // Enhanced for-loop: iterates over every Song in the array
            for (Song s : songs) {
                if (s == null) break;   // stop when we reach unfilled slots
                System.out.println(number + ". " + s.getTitle()
                                   + " - " + s.getArtist());
                number++;
            }
        }

        // ── Method 3: shufflePlaylist() ───────────────────────
        /**
         * Randomly rearranges the songs using the Fisher-Yates algorithm.
         *
         * Fisher-Yates shuffle logic:
         *   Start from the last song and work backwards.
         *   Pick a random index from 0..i (inclusive).
         *   Swap songs[i] with songs[randomIndex].
         * This guarantees a perfectly uniform random permutation.
         */
        public void shufflePlaylist() {
            Random random = new Random();  // Random object for generating random indices

            // Iterate from the last song down to index 1
            for (int i = count - 1; i > 0; i--) {

                // Pick a random position between 0 and i (inclusive)
                int j = random.nextInt(i + 1);

                // Swap songs[i] and songs[j]
                Song temp = songs[i];
                songs[i]  = songs[j];
                songs[j]  = temp;
            }
        }
    }

    // ============================================================
    //  MAIN METHOD – entry point, tests the entire system
    // ============================================================
    public static void main(String[] args) {

        // Step 1: Create a Playlist that holds up to 10 songs
        Playlist myPlaylist = new Playlist(10);

        // Step 2: Create Song objects
        Song s1 = new Song("Believer",       "Imagine Dragons", "Rock");
        Song s2 = new Song("Shape of You",   "Ed Sheeran",      "Pop");
        Song s3 = new Song("Blinding Lights","The Weeknd",      "Pop");
        Song s4 = new Song("Levitating",     "Dua Lipa",        "Pop");
        Song s5 = new Song("Stay",           "The Kid Laroi",   "Pop");

        // Step 3: Add songs to the playlist
        myPlaylist.addSong(s1);
        myPlaylist.addSong(s2);
        myPlaylist.addSong(s3);
        myPlaylist.addSong(s4);
        myPlaylist.addSong(s5);

        // Step 4: Display the original playlist
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║        Original Playlist     ║");
        System.out.println("╚══════════════════════════════╝");
        myPlaylist.displayQueue();

        // Step 5: Shuffle the playlist
        System.out.println("\nShuffling Playlist...\n");
        myPlaylist.shufflePlaylist();

        // Step 6: Display the shuffled playlist
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║        Shuffled Playlist     ║");
        System.out.println("╚══════════════════════════════╝");
        myPlaylist.displayQueue();
    }
}