package net.moewes;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LandingRoutes {

    @Route(path="/landing")
    void testRoute(RoutingExchange ex) {
        ex.context().redirect("/api/todos");
        //ex.ok("Hallo");
    }
}
