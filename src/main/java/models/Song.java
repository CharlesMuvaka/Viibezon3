package models;

public class Song {
    	private int id;
	private String title;

	private int recordLabelId;
	private int musicianId;

	public Song(String title, int recordLabelId, int musicianId) {
		this.title = title;
		this.recordLabelId = recordLabelId;
		this.musicianId = musicianId;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}


	public int getRecordLabelId() {
		return recordLabelId;
	}

	public int getMusicianId() {
		return musicianId;
	}
}
