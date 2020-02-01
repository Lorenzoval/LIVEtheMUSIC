package logic.login;

import logic.bean.ArtistBean;
import logic.bean.GeneralUserBean;
import logic.bean.UserBean;
import logic.dao.DAOFactory;
import logic.dao.ArtistDAO;
import logic.dao.GeneralUserDAO;
import logic.dao.UserDAO;
import logic.entity.GeneralUser;

public class LoginController {

	private DAOFactory df;
	
	public static void main(String[] args) {
		System.out.println("To Implement");
	}
	
	public LoginController() {
		// TODO here we should read from a config file the type of DB to be used
		this.df = DAOFactory.getDAOFactory(DAOFactory.DBMS.MYSQL);
	}
	
	public GeneralUserBean login(GeneralUserBean userBean) {
		GeneralUserDAO gud = df.getGeneralUserDAO();
		GeneralUser result = gud.findUser(userBean.getUsername(), userBean.getPassword());
		if(result == null)	return null;
		else return new GeneralUserBean(result);
	}
	
	public boolean createUser(UserBean ub) {
		UserDAO ud = df.getUserDAO();
		return ud.createUser(ub.getUsername(), ub.getPassword(), ub.getName(), ub.getSurname(), ub.getEmail()); 
	}
	
	public boolean createArtist(ArtistBean ab) {
		ArtistDAO ad = df.getArtistDAO();
		return ad.createArtist(ab.getUsername(), ab.getPassword(), ab.getBandName(), ab.getProfilePicture(), ab.getEmail());
	}
}
