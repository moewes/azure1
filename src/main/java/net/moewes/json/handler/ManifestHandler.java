package net.moewes.json.handler;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import net.moewes.json.repository.AppRepository;

@ApplicationScoped
public class ManifestHandler {

    @Inject
    AppRepository appRepository;

    @Route(path = "/ui5/manifest.json")
    public void testRoute(RoutingExchange ex) {

        JsonObject json = JsonObject.mapFrom(appRepository.getManifestForApp(""));
        ex.ok(json.encode());
    }
}
