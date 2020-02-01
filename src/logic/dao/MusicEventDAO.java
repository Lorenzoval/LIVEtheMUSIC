package logic.dao;

import java.util.List;

import logic.entity.MusicEvent;

public interface MusicEventDAO {

	public List<MusicEvent> getSuggestedEvents(String username);
	public List<MusicEvent> getSearchMusicEvent(String searchString);
	public void addParticipation(String username, String musicEventId);
	public void removeParticipation(String username, String musicEventId);
	public boolean isParticipating(String username, String musicEventId);

}
