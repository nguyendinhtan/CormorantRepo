import java.util.List;

public class Person {
	private String name;
	private String gender;
	private List<String> culture;
	private String occupation;
	private String notes;

	public Person(String name, String gender, List<String> culture, String occupation, String notes) {
		this.name = name;
		this.gender = gender;
		this.culture = culture;
		this.occupation = occupation;
		this.notes = notes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getCulture() {
		return culture;
	}

	public void setCulture(List<String> culture) {
		this.culture = culture;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
