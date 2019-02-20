package application;

public class Song {
	private String title;
	private String artist;
	private String album;
	private String year;
	
	public Song(String title, String artist, String album, String year) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
	}
	
	public Song(String line) {
		int startPos=1;
		int endPos=0;
		
		endPos = line.indexOf("\",\"", endPos+1);
		this.title = line.substring(startPos, endPos);
		
		startPos = endPos + 3;
		endPos = line.indexOf("\",\"", endPos+1);
		this.artist = line.substring(startPos, endPos);
		
		startPos = endPos + 3;
		endPos = line.indexOf("\",\"", endPos+1);
		this.album = line.substring(startPos, endPos);
		
		startPos = endPos + 3;
		endPos = line.indexOf("\"", endPos+3);
		this.year = line.substring(startPos, endPos);
		
	}
	
	public String toString() {
		return this.title + " by " + this.artist + " in Album: " + this.album + " released in Year " + this.year;
	}
	
	public String printToFileString() {
		String s = "\"" + this.title + "\",\"" + this.artist + "\",\"" + this.album + "\",\"" + this.year + "\"\n";
		return s;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public String getAlbum() {
		return this.album;
	}
	
	public String getYear() {
		return this.year;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public void setAlbum(String album) {
		this.album = album;
	}
	
	public void setYear(String year) {
		this.year = year;
	}

}
