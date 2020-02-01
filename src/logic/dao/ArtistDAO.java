package logic.dao;

import java.util.List;

import logic.entity.Artist;

public interface ArtistDAO {
	
	public List<Artist> getSuggestedArtist(String username);
	public List<Artist> getSearchArtist(String searchString);
	public boolean createArtist(String username, String password,
			String bandName, String profilePicture, String email);
}
