package p05OnlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Playlist playlist = new Playlist();


        for (int i = 0; i < n; i++) {
            String[] songTokens = reader.readLine().split(";");
            if(songTokens.length != 3){
                continue;
            }
            String artistName = songTokens[0];
            String songName = songTokens[1];
            String songLength = songTokens[2];

            try {
                Song song = new Song(artistName, songName, songLength);
                playlist.addSong(song);
                System.out.println("Song added.");
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        System.out.println("Songs added: " + playlist.getSongs().size());
        System.out.printf("Playlist length: %dh %dm %ds%n", playlist.getPlaylistLength() / 3600,
                (playlist.getPlaylistLength() % 3600) / 60,
                playlist.getPlaylistLength() % 60);
    }
}
