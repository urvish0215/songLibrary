//Urvish Patel uyp2
//Mohammed Rupani mrr184

package application;

import java.util.Comparator;

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
		return this.title + " by " + this.artist;
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
	
	public boolean equals(Song x) {
		if(x.getTitle().compareToIgnoreCase(this.title) != 0) {
			return false;
		}else if(x.getArtist().compareToIgnoreCase(this.artist) != 0) {
			return false;
		}else if(x.getAlbum().compareToIgnoreCase(this.album) != 0) {
			return false;
		}else if(x.getYear().compareToIgnoreCase(this.year) != 0){
			return false;
		}else {
			return true;
		}
	}
	
	public boolean isDuplicate(String title, String artist) {
		if(title.compareToIgnoreCase(this.title) == 0 && artist.compareToIgnoreCase(this.artist) == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Comparator<Song> songTitleComparator = new Comparator<Song>() {
		
		public int compare(Song a, Song b) {
			if(a.getTitle().compareToIgnoreCase(b.getTitle()) == 0) {
				return a.getArtist().compareToIgnoreCase(b.getArtist());
			}else {
				return a.getTitle().compareToIgnoreCase(b.getTitle());
			}
		}
	};

}
