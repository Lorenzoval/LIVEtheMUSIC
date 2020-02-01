package logic.dao;

public interface UserDAO {

	public boolean createUser(String username, String password,
    		String firstName, String lastName, String email);

}
