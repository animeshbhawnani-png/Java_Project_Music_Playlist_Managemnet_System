# Music Playlist Management System

## Overview

The Music Playlist Management System is a Java-based console application developed using Object-Oriented Programming (OOP) concepts. The project demonstrates how songs can be organized and managed within a playlist using aggregation, encapsulation, arrays of objects, and randomization techniques.

The system allows users to:

* Add songs to a playlist
* Display the playlist queue
* Shuffle the playlist using the Fisher-Yates Shuffle Algorithm

---

## Features

* Add songs to a playlist
* Store song details (title and artist)
* Display playlist contents
* Shuffle playlist randomly
* Demonstrates Aggregation (HAS-A relationship)
* Uses Arrays of Objects
* Implements Encapsulation
* Uses Enhanced For-Loop Traversal

---

## OOP Concepts Used

### Encapsulation

The Song and Playlist classes use private data members with controlled access through public methods.

### Aggregation (HAS-A Relationship)

A Playlist object contains multiple Song objects using an array.

### Arrays of Objects

Songs are stored and managed using a Song[] array.

### Randomization

The Fisher-Yates Shuffle Algorithm is used to randomize playlist order.

---

## Class Structure

### Song Class

Attributes:

* title
* artist

Methods:

* getTitle()
* getArtist()
* toString()

### Playlist Class

Attributes:

* Song[] songs
* int count

Methods:

* addSong()
* displayPlaylist()
* shufflePlaylist()

### MusicApp Class

Contains the main() method used to test the application.

---

## Sample Output

Original Playlist

Playlist:

1. Believer - Imagine Dragons
2. Shape of You - Ed Sheeran
3. Blinding Lights - The Weeknd

Shuffling Playlist...

Shuffled Playlist:

1. Blinding Lights - The Weeknd
2. Believer - Imagine Dragons
3. Shape of You - Ed Sheeran

---

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Arrays
* Fisher-Yates Shuffle Algorithm

---

## How to Run

1. Save the file as `MusicApp.java`
2. Open a terminal in the project directory.
3. Compile the program:

```bash
javac MusicApp.java
```

4. Run the program:

```bash
java MusicApp
```

---

## Future Enhancements

* Remove songs from playlist
* Search songs by title or artist
* Use LinkedList instead of fixed-size arrays
* Add database support (MySQL/SQLite)
* Develop a GUI using JavaFX or Swing
* Support multiple playlists and user profiles

---

## Author

**Animesh Bhawnani**
B.Tech CSE (AI & ML)
Rungta International Skills University

---

## License

This project is created for educational and academic purposes.
