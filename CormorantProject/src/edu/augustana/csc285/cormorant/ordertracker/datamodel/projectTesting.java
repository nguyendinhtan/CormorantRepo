package edu.augustana.csc285.cormorant.ordertracker.datamodel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class projectTesting {
	Person jared=new Person(1,"Jared","J-rod", "Male","american","student","none");
	Person bob=new Person(4,"Robert","bob", "Male","american","Professor","none");
	Person dan=new Person(5,"Dan","D", "Male","French","Painter","none");
	List<Person> group1=new ArrayList<Person>();
	List<Person> group2=new ArrayList<Person>();
	List<Person> group3=new ArrayList<Person>();
	Interaction interaction1=new Interaction(group1, group2, "Rock Island", "12/25/2014", "Letter", "none", "none", true);
	Interaction interaction2=new Interaction(group1, group3, "Moline", "4/19/2001", "Journal", "none", "none", true);
	
	@Test
	public void testDuplicateChecker() {
		group1.add(jared);
		group2.add(bob);
		group3.add(bob);
		assertEquals(-1,DataCollections.checkForPersonDuplicates(jared));
		DataCollections.addPerson(jared);
		assertEquals(1,DataCollections.checkForPersonDuplicates(jared));
		assertEquals(-1,DataCollections.checkForPersonDuplicates(bob));
		DataCollections.addPerson(bob);
		assertEquals(4,DataCollections.checkForPersonDuplicates(bob));
		assertEquals(-1, DataCollections.checkForInteractionDuplicates(interaction1));
		DataCollections.addInteraction(interaction1);
		assertEquals(0, DataCollections.checkForInteractionDuplicates(interaction1));
		assertEquals(-1, DataCollections.checkForInteractionDuplicates(interaction2));
		DataCollections.addInteraction(interaction2);
		assertEquals(1,DataCollections.checkForInteractionDuplicates(interaction2));
	}
	public void testCheckUnallowedInput(){
		assertEquals(-1,jared.checkForUnallowedInput("249834", ""));
		assertEquals(0,jared.checkForUnallowedInput("jared", "j-rod"));
		assertEquals(0,jared.checkForUnallowedInput("",""));
		assertEquals(-1,bob.checkForUnallowedInput("robert$",""));
		assertEquals(-1,bob.checkForUnallowedInput("", ""));
	}
}
