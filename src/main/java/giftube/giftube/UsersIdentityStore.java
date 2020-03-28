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
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import javax.security.enterprise.identitystore.IdentityStore;

/**
 *
 * @author Jesus
 */

@ApplicationScoped
public class UsersIdentityStore implements IdentityStore {

    private Map<String, String> credenciales;

    public UsersIdentityStore() {
        credenciales = new HashMap<>();
        credenciales.put("usuario0", "clave0");
        credenciales.put("usuario1", "clave1");
    }

    public CredentialValidationResult validate(
            UsernamePasswordCredential usernamePasswordCredential) {
                String username = usernamePasswordCredential.getCaller();
                String password = usernamePasswordCredential.getPasswordAsString();
                String validPassword = credenciales.get(username);
        if (validPassword != null && validPassword.equals(password)) {
            Set<String> roles = new HashSet<>(Arrays.asList("USUARIOS"));
            return new CredentialValidationResult(username, roles);
        }
        return INVALID_RESULT;
    }

}
