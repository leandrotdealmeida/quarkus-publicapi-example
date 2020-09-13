package japa.com.br;

import japa.com.br.data.Currency;
import japa.com.br.service.CurrencyService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.concurrent.CompletionStage;

@Path("/crypto")
public class CryptoCurrencyResource {

    @Inject
    @RestClient
    CurrencyService currencyService;

    @GET
    @Path("health")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CompletionStage<Collection<Currency>> getCrypto(@QueryParam("id") String id) {
        return currencyService.getCurrency(id);

    }
}