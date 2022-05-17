package models;

import java.util.Objects;

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

	public void setGenre() {
		setGenre(null);
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Song song = (Song) o;
		return id == song.id && musicianid == song.musicianid && title.equals(song.title) && genre.equals(song.genre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, genre, musicianid);
	}

	public void setMusicianid(int musicianid) {
		this.musicianid = musicianid;
	}
}
