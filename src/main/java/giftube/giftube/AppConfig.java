/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import org.glassfish.soteria.identitystores.annotation.Credentials;
import org.glassfish.soteria.identitystores.annotation.EmbeddedIdentityStoreDefinition;

/**
 *
 * @author Jesus
 */
@EmbeddedIdentityStoreDefinition({ //Usuarios Predefinidos
    @Credentials(callerName = "unijaen22", password = "unijaen22", groups = {"ADMINISTRADORES"}),
    @Credentials(callerName = "ZenXuu", password = "100mariposa", groups = {"ADMINISTRADORES"}),
    @Credentials(callerName = "usuario1", password = "usuario1", groups = {"USUARIOS"})
})
@FormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/GIF/login.xhtml",
                errorPage = "/GIF/login.xhtml?error",
                useForwardToLogin = false
        )
)
@ApplicationScoped
@FacesConfig
public class AppConfig {
}
