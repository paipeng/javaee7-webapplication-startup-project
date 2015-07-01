package com.paipeng.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.paipeng.jms.MessageSender;
import com.paipeng.jpa.model.Lotto;
import com.paipeng.jpa.service.LottoService;

@RequestScoped
@Path("")
public class TestRest {

	@Inject
	protected Logger log;
	
	@Inject
	protected LottoService lottoService;
	
	@Inject
	protected MessageSender messageSender;

	@PostConstruct
	public void postConstruct() {
		log.info("postConstruct");
	}
	
	@Path("/echo")
	@Produces("application/json")
	@GET
	@POST
	public Response echo(@QueryParam("echo") String echo) {
		log.info("echo: " + echo);
		return Response.ok(echo).build();
	}
	
	@Path("/lottos")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@GET
	@POST
	public List<Lotto> lottos() {
		log.info("lottos");
		List<Lotto> lottoList = lottoService.getLottos();
		return lottoList;
	}
	
	
	@Path("/newLotto")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@GET
	@POST
	public Lotto newLotto() {
		log.info("newLotto");
		Lotto lotto = lottoService.getLastLotto();
		return lotto;
	}
	
	@Path("/jms/")
	@Produces({MediaType.APPLICATION_JSON})
	@GET
	@POST
	public Response sendJMS(@QueryParam("message") String message) {
		log.info("sendJMS " + message);
		
		messageSender.sendMessage(message);
		return Response.ok(message).build();
	}
	
	
}
