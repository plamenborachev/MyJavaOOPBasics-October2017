package p05OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
    private List<Song> songs;

    public Playlist(){
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song){
        this.songs.add(song);
    }

    public List<Song> getSongs(){
        return Collections.unmodifiableList(songs);
    }

    public long getPlaylistLength(){
        int playListLength = 0;
        for (Song song: songs) {
            playListLength += song.getMinutes() * 60 + song.getSeconds();
        }
        return playListLength;
    }
}
