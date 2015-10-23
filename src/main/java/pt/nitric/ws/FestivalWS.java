package pt.nitric.ws;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import pt.nitric.ejb.FestivalEJB;
import pt.nitric.entities.Festival;

@Stateless
@WebService
public class FestivalWS {

	@Inject
	private FestivalEJB festivalEjb;

	public FestivalWS() {
	}

	@WebMethod
	public void addFestival(String name) {
		festivalEjb.create(name);
	}

	@WebMethod
	public List<Festival> getAll() {
		return festivalEjb.find();
	}

}
