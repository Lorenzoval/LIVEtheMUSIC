package logic.dao;

import logic.entity.GeneralUser;

public interface GeneralUserDAO {

	public GeneralUser findUser(String username, String password);

}
