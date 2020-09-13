package japa.com.br.service;

import japa.com.br.data.Currency;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.concurrent.CompletionStage;

@RegisterRestClient(configKey = "config.api.crypto")
@Path("ticker")
public interface CurrencyService {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    CompletionStage<Collection<Currency>> getCurrency(@QueryParam("id") String id);
}
