import java.util.*;

public class Interaction {
	private List<Person> people;
	private String location;
	private Date date;
	private List<String> interactionType;
	private List<String> citation;
	private String notes;

	public Interaction(List<Person> people, String location, Date date, List<String> interactionType,
			List<String> citation, String notes) {
		this.people = people;
		this.location = location;
		this.date = date;
		this.interactionType = interactionType;
		this.citation = citation;
		this.notes = notes;
	}

	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<String> getInteractionType() {
		return interactionType;
	}

	public void setInteractionType(List<String> interactionType) {
		this.interactionType = interactionType;
	}

	public List<String> getCitation() {
		return citation;
	}

	public void setCitation(List<String> citation) {
		this.citation = citation;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
