package models;

public class Song {
    	private int id;
	private String title;

	private String genre;
	private int musicianid;

	public Song(String title, String genre, int musicianId) {
		this.title = title;
		this.genre = genre;
		this.musicianid = musicianId;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}


	public String getGenre() {
		return genre;
	}

	public int getMusicianid() {
		return musicianid;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setMusicianid(int musicianid) {
		this.musicianid = musicianid;
	}
}
