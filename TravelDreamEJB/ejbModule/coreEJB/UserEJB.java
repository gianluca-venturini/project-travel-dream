package coreEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dto.UserDTO;
import entity.User;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

/**
 * Session Bean implementation class UserEJB
 */
@Stateless
public class UserEJB implements UserEJBLocal {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public UserEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public boolean authenticateUser(UserDTO userDTO) {
    	if(userDTO == null || userDTO.getMail() == null)
    		return false;
    	User user = em.find(User.class, userDTO.getMail());
    	
    	if(user == null)
    		return false;
    	
    	//Calculate hashed password
    	String hashedPsw = null; // = Hashing.sha256().hashString(userDTO.getPassword(), Charsets.UTF_8).toString();
    	
    	System.out.println("Hash: "+hashedPsw);
    	
    	if(user.getPassword().equals(hashedPsw)) {
    		return true;
    	}
    	
    	return false;
    	
    }

}
