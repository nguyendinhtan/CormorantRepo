import java.util.*;

public class Interaction {
	private Person person1;
	private Person person2;
	private String location;
	private Date date;
	private List<String> interactionType;
	private List<String> citation;
	private String notes;
	
	public Interaction(Person person1, Person person2){
		this.person1=person1;
		this.person2=person2;	
	}
	
	public Person getPerson1() {
		return person1;
	}
	public void setPerson1(Person person1) {
		this.person1 = person1;
	}
	public Person getPerson2() {
		return person2;
	}
	public void setPerson2(Person person2) {
		this.person2 = person2;
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
