package net.moewes.json.handler;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.core.json.JsonObject;
import net.moewes.json.MyPayload;
import net.moewes.json.MyRoute;
import net.moewes.json.repository.AppRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

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
