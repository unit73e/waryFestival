package pt.nitric.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Festival.FIND_ALL, query = "select c from Festival c")
public class Festival {

	public static final String FIND_ALL = "Festival.findAll";

	@Id
	@GeneratedValue
	private String id;
	private String name;

	public Festival() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
