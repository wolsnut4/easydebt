package org.wolsnut4.services.resources;

import org.jboss.logging.Logger;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.wolsnut4.models.UserModel;
import org.wolsnut4.models.UserProvider;
import org.wolsnut4.representations.idm.UserRepresentation;
import org.wolsnut4.utils.ModelToRepresentation;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.Map;

@Path("/user")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class);

    @Context
    private UriInfo uriInfo;

    @Inject
    private UserProvider userProvider;

    @Resource
    private UserTransaction utx;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserRepresentation getCurrentUser(@Context final HttpServletRequest httpServletRequest) {
        KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) httpServletRequest.getUserPrincipal();
        AccessToken accessToken = principal.getKeycloakSecurityContext().getToken();

        String kcUserID = principal.getName();
        String kcUsername = accessToken.getPreferredUsername();

        // Get user from DB
        UserModel user = this.userProvider.getUserByIdentityID(kcUserID);
        if (user == null) {
            user = this.userProvider.addUser(kcUserID, "kc", kcUsername);
        }
        mergeKeycloakUser(user, accessToken);

        // Result
        return ModelToRepresentation.toRepresentation(user, uriInfo).toUserRepresentation();
    }

    private void mergeKeycloakUser(UserModel user, AccessToken accessToken) {
        if (accessToken.getEmail() != null && !accessToken.getEmail().equals(user.getEmail())) {
            user.setEmail(accessToken.getEmail());
        }

        if (accessToken.getName() != null && !accessToken.getName().equals(user.getFullName())) {
            user.setFullName(accessToken.getName());
        }

        Map<String, Object> attributes = accessToken.getOtherClaims();
        if (attributes != null) {
            Object imageURL = attributes.get("imageURL");
            if (imageURL != null) {
                String imageURLAttribute = (String) imageURL;
                if (!imageURLAttribute.equals(user.getImageURL())) user.setImageURL(imageURLAttribute);
            }
        }
    }

}