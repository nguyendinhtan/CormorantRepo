public class Main {

	public static void main(String[] args) {
		Collections personList = new Collections();
        Person person=new Person(1,"Jared", "M", "US", "student", "csc major");
    	personList.addPerson(person);
    	System.out.println(personList.getPersonCollection().get(0).toString());
		
	}

}
