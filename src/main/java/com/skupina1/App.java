package com.skupina1;

import com.skupina1.config.JaxRsApplication;
import jakarta.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.net.URI;

public class App {

    public static void main(String[] args) {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        URI baseUri = UriBuilder.fromUri("http://0.0.0.0/").port(8082).build();

        ResourceConfig config = new ResourceConfig()
                .packages("com.skupina1")
                .register(JaxRsApplication.class);

        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);

        System.out.println("Drive Request service running at: http://localhost:8082/api");
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));
    }
}