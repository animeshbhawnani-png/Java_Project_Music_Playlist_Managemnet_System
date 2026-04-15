# Music Playlist

A simple Java application that demonstrates basic object-oriented programming concepts through a music playlist manager.

## Features

- **Add Songs**: Add songs with title and artist information to a playlist
- **Display Playlist**: View all songs currently in the playlist
- **Shuffle**: Randomly shuffle the order of songs in the playlist

## Project Structure

- `Song.java` (class): Represents a single song with title and artist
- `Playlist.java` (class): Manages a collection of songs with add, display, and shuffle operations
- `MusicPlaylist.java` (main): Entry point that demonstrates playlist functionality

## Usage

### Compile
```bash
javac MusicPlaylist.java
```

### Run
```bash
java MusicPlaylist
```

### Example Output
```
Playlist:
1. Believer - Imagine Dragons
2. Shape of You - Ed Sheeran
3. Blinding Lights - The Weeknd

Shuffled:
3. Blinding Lights - The Weeknd
1. Believer - Imagine Dragons
2. Shape of You - Ed Sheeran
```

## How It Works

1. Creates a Playlist with a maximum capacity
2. Adds songs to the playlist
3. Displays the playlist in order
4. Shuffles the playlist using the Fisher-Yates algorithm
5. Displays the shuffled playlist

## Requirements

- Java 8 or higher

## License

MIT
