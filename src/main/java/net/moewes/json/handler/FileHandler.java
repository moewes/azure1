package net.moewes.json.handler;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import net.moewes.json.repository.AppRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FileHandler {

    @Inject
    AppRepository appRepository;

    @Route(path = "/ui5/file")
    public void testRoute(RoutingExchange ex) {

        Future<Buffer> bufferFuture = ex.context()
                .vertx()
                .fileSystem()
                .readFile("META-INF/resources/ui5/App.View.xml");

        bufferFuture.onComplete(bufferAsyncResult -> {
            ex.ok(bufferAsyncResult.result().toString());
        });
    }
}