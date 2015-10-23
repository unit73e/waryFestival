package pt.nitric.ejb;

import pt.nitric.entities.Festival;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class FestivalEJB {

	@PersistenceContext(unitName = "waryFestivalPU")
	private EntityManager em;

	public FestivalEJB() {
	}

	public List<Festival> find() {
		TypedQuery<Festival> query = em.createNamedQuery(Festival.FIND_ALL, Festival.class);
		return query.getResultList();
	}

	public void create(String name) {
		Festival festival = new Festival();
		festival.setName(name);
		em.persist(festival);
	}
}
