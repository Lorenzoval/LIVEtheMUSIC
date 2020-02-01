package logic.dao;

import logic.utils.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLUserDAO implements UserDAO{
	

    private static final Logger logger = Logger.getLogger(MySQLUserDAO.class.getName());
    
    @Override
    public boolean createUser(String username, String password,
    		String firstName, String lastName, String email) {
    	Connection con = null;
    	try {
    		con = DBLoginConnection.getLoginConnection();
    		Queries.addUser(con, username, password, email, firstName, lastName);
    		
    	} catch (SQLException se) {
        	logger.log(Level.WARNING, se.toString());
        	return false;
        } catch (ClassNotFoundException e) {
            logger.log(Level.WARNING, e.toString());
            return false;
        }
    	return true;
    }
    
}
