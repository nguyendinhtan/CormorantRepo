import java.util.*;

public class Interaction {
	private List<Person> people1;
	private List<Person> people2;
	private String location;
	private Date date;
	private List<String> interactionType;
	private List<String> citation;
	private String notes;
	private boolean directed;

	public Interaction(List<Person> people1, List<Person> people2, String location, Date date, List<String> interactionType,
			List<String> citation, String notes, boolean directed) {
		this.people1 = people1;
		this.people2 = people2;
		this.location = location;
		this.date = date;
		this.interactionType = interactionType;
		this.citation = citation;
		this.notes = notes;
		this.directed = directed; 
	}

	public List<Person> getPeople1() {
		return people1;
	}
	
	public List<Person> getPeople2() {
		return people2;
	}

	public void setPeople1(List<Person> people) {
		this.people1 = people;
	}
	
	public void setPeople2(List<Person> people) {
		this.people2 = people;
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
	
	public boolean isDirected(boolean directed){
		return this.directed;
	}
}
