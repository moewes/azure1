package net.moewes;

import io.quarkus.oidc.AccessTokenCredential;
import io.quarkus.oidc.IdToken;
import io.quarkus.oidc.IdTokenCredential;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Inject;
import net.moewes.cloudui.quarkus.runtime.identity.Identity;
import org.eclipse.microprofile.jwt.JsonWebToken;

@RequestScoped
public class IdentityProducer {

    private class NamedLiteral extends AnnotationLiteral<IdToken> implements IdToken {
// FIXME Name
    }

    @Inject
    @IdToken
    JsonWebToken idToken;

    @Inject
    SecurityIdentity identity;

    @Produces
    @RequestScoped
    public Identity identity() {

        // FIXME
        // JsonWebToken idToken = (JsonWebToken) CDI.current().select(JsonWebToken.class, new NamedLiteral()).get();
        IdTokenCredential cred = identity.getCredential(IdTokenCredential.class);
        AccessTokenCredential cred2 = identity.getCredential(AccessTokenCredential.class);
        //UserInfo userInfo = (UserInfo) identity.getAttribute(OidcUtils.USER_INFO_ATTRIBUTE);

        return new OidcIdentity(identity);
    }
}
