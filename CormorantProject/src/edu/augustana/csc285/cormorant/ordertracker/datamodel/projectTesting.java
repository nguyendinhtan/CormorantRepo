package edu.augustana.csc285.cormorant.ordertracker.datamodel;

import static org.junit.Assert.*;

import org.junit.Test;

public class projectTesting {
	Person jared=new Person(1,"Jared","j-rod", "Male","american","student","none");
	Person bob=new Person(1,"Jared","j-rod", "Male","american","student","none");
	@Test
	public void test() {
		assertEquals(-1,DataCollections.checkForPersonDuplicates(jared));
		
	}

}
