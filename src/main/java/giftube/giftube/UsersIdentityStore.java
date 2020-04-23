/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import javax.security.enterprise.identitystore.IdentityStore;
import javax.servlet.ServletException;

/**
 *
 * @author Jesus
 */

@ApplicationScoped
public class UsersIdentityStore implements IdentityStore {
    @Inject 
    private Preferencias pref;
    
    @PersistenceContext
    private EntityManager em;
       
    private Map<String, String> credenciales;
    private static final Logger logger = Logger.getLogger(UsersIdentityStore.class.getName());
    public UsersIdentityStore() {
        credenciales = new HashMap<>();
        credenciales.put("usuario0", "clave0");
        credenciales.put("usuario1", "clave1");
    }

    public CredentialValidationResult validate(
            
            UsernamePasswordCredential usernamePasswordCredential) throws ServletException {
                String username = usernamePasswordCredential.getCaller();
                
                String password = usernamePasswordCredential.getPasswordAsString();
                Cliente c = em.find(Cliente.class, username);
                if(c==null){
                    pref.logout();
                    pref.loggout();
                    return INVALID_RESULT;}
                else{
                    pref.setC(c);
                    String validPassword = c.getPassword();
                    pref.setActualUsuarioid(username);
                
        if (validPassword != null && validPassword.equals(password)) {
            Set<String> roles = new HashSet<>(Arrays.asList("USUARIOS"));
            return new CredentialValidationResult(username, roles);
        }else{
            pref.logout();
            pref.loggout();
        }
        }
        return INVALID_RESULT;
    }

}
