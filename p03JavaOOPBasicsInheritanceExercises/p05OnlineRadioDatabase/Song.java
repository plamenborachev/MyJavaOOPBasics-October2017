package p05OnlineRadioDatabase;

public class Song {
    private String artistName;
    private String songName;
    private String songLength;
    private  int minutes;
    private  int seconds;

    public Song(String artistName, String songName, String songLength) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setSongLength(songLength);
    }

    private void setArtistName(String artistName){
        if(artistName.length() < 3 || 20 < artistName.length()){
            throw new IllegalArgumentException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName){
        if(songName.length() < 3 || 30 < songName.length()){
            throw new IllegalArgumentException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setSongLength(String songLength){
        String[] tokens = songLength.split(":");
        int minutes;
        int seconds;
        try{
            minutes = Integer.parseInt(tokens[0]);
            seconds = Integer.parseInt(tokens[1]);
        } catch (NumberFormatException nfe){
            throw new IllegalArgumentException("Invalid song length.");
        }

        this.setMinutes(minutes);
        this.setSeconds(seconds);

        int songLengthInSec = minutes * 60 + seconds;
        int maxLength = 14 * 60 + 59;
        if (songLengthInSec < 0 || maxLength < songLengthInSec){
            throw new IllegalArgumentException("Invalid song length.");
        }
        this.songLength = songLength;
    }

    public int getMinutes() {
        return this.minutes;
    }

    private void setMinutes(int minutes){
        if (minutes < 0 || 14 < minutes){
            throw new IllegalArgumentException("Song minutes should be between 0 and 14.");
        }
        this.minutes = minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    private void setSeconds(int seconds){
        if (seconds < 0 || 59 < seconds){
            throw new IllegalArgumentException("Song seconds should be between 0 and 59.");
        }
        this.seconds = seconds;
    }
}
