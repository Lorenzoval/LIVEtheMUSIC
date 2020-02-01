package logic.buyticket;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.bean.ArtistBean;
import logic.bean.GeneralUserBean;
import logic.bean.MusicEventBean;
import logic.bean.UserBean;
import logic.dao.DAOFactory;
import logic.dao.ArtistDAO;
import logic.dao.MusicEventDAO;
import logic.entity.Artist;
import logic.entity.MusicEvent;
import logic.entity.User;

public class BuyTicketController {
	
	private DAOFactory df;
	
	private static final Logger logger = Logger.getLogger(BuyTicketController.class.getName());
	
	public BuyTicketController() {
		this.df = DAOFactory.getDAOFactory(DAOFactory.DBMS.MYSQL);
	}

	public List<MusicEventBean> getSuggestedEvents(String username) {
		MusicEventDAO med = df.getMusicEventDAO();

		List<MusicEvent> l = med.getSuggestedEvents(username);
		List<MusicEventBean> lb = new ArrayList<>();
		for(int i = 0; i < l.size(); i++) {
			lb.add(new MusicEventBean(l.get(i)));
		}
		
		return lb;
	}
	
	public List<MusicEventBean> getSearchMusicEvent(String searchString) {
		MusicEventDAO med = df.getMusicEventDAO();

		List<MusicEvent> l = med.getSearchMusicEvent(searchString);
		List<MusicEventBean> lb = new ArrayList<>();
		for(int i = 0; i < l.size(); i++) {
			lb.add(new MusicEventBean(l.get(i)));
		}
		
		return lb;
	}
	
	public List<ArtistBean> getSearchArtist(String searchString) {
		ArtistDAO ad = df.getArtistDAO();

		List<Artist> l = ad.getSearchArtist(searchString);
		List<ArtistBean> lb = new ArrayList<>();
		for(int i = 0; i < l.size(); i++) {
			lb.add(new ArtistBean(l.get(i)));
		}
		
		return lb;
	}
	
	public List<ArtistBean> getSuggestedArtist(String username){
		ArtistDAO ad = df.getArtistDAO();
		List<Artist> l = ad.getSuggestedArtist(username);
		List<ArtistBean> lb = new ArrayList<>();
		for(int i = 0; i < l.size(); i++) {
			lb.add(new ArtistBean(l.get(i)));
		}
		
		return lb;
	}
	
	public void addParticipation(GeneralUserBean user, MusicEventBean meb) {
		MusicEventDAO med = df.getMusicEventDAO();
		med.addParticipation(user.getUsername(), meb.getId());
	}
	
	public void removeParticipation(GeneralUserBean user, MusicEventBean meb) {
		MusicEventDAO med = df.getMusicEventDAO();
		med.removeParticipation(user.getUsername(), meb.getId());
	}
	
	public boolean isParticipating(GeneralUserBean user, MusicEventBean meb) {
		MusicEventDAO med = df.getMusicEventDAO();
		return med.isParticipating(user.getUsername(), meb.getId());
	}
}
