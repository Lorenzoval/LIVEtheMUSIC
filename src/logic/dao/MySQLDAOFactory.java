package logic.dao;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public ArtistDAO getArtistDAO() {
		return new MySQLArtistDAO();
	}

	@Override
	public GeneralUserDAO getGeneralUserDAO() {
		return new MySQLGeneralUserDAO();
	}

	@Override
	public MusicEventDAO getMusicEventDAO() {
		return new MySQLMusicEventDAO();
	}

	@Override
	public UserDAO getUserDAO() {
		return new MySQLUserDAO();
	}

}
