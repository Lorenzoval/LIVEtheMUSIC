package logic.dao;

import logic.entity.GeneralUser;
import logic.utils.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLGeneralUserDAO implements GeneralUserDAO {
	

    private static final Logger logger = Logger.getLogger(MySQLGeneralUserDAO.class.getName());
    
    @Override
    public GeneralUser findUser(String username, String password) {
        Connection conn = null;
        GeneralUser u = null;
        try {
            conn = DBLoginConnection.getLoginConnection();
            
            ResultSet rs = Queries.selectGeneralUserLogin(conn, username, password);

            if (!rs.first()) // rs not empty
                return null;

            boolean moreThanOne = rs.first() && rs.next();
            assert !moreThanOne;
            rs.first();

            String role = rs.getString("role");
            String usernameLoaded = rs.getString("username");
            
            if(usernameLoaded.equals(username)) {
            	u = new GeneralUser(usernameLoaded, "", role);
            }

            rs.close();

        } catch (SQLException se) {
        	logger.log(Level.WARNING, se.toString());
        } catch (ClassNotFoundException e) {
            logger.log(Level.WARNING, e.toString());
        } finally {
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            	logger.log(Level.WARNING, se2.toString());
//            }
        }
        //System.out.println("Found " + u.getRole() + "with username" + u.getUsername());
        return u;
    }
}
