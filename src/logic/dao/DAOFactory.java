package logic.dao;

public abstract class DAOFactory {
	
	// TODO try to use reflection
	public static enum DBMS {
		MYSQL;
	}

	public abstract ArtistDAO getArtistDAO();
	public abstract GeneralUserDAO getGeneralUserDAO();
	public abstract MusicEventDAO getMusicEventDAO();
	public abstract UserDAO getUserDAO();
	
	public static DAOFactory getDAOFactory(DBMS database) {
		
		switch(database) {
		case MYSQL:
			return new MySQLDAOFactory();
		default:
			return null;
		}
	}
	
}
