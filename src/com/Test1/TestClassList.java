package com.Test1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.Test1.ClassList.DuplicateDataException;

class TestClassList {
	private ClassList theClass;

	@Test
	void testClassList() {
		assertThrows(NullPointerException.class, () -> theClass.getTeacherName());
		theClass = new ClassList("MP");
		assertEquals("MP", theClass.getTeacherName());
		assertEquals(0, theClass.getQtyNames());
	}

	@Test
	void testAddStudentName() {
		try {
			theClass = new ClassList("MP");
			assertEquals(0, theClass.getQtyNames());
			assertFalse(theClass.contains("Anastasiia Shalamova"));
			theClass.addStudentName("Anastasiia Shalamova");
			assertTrue(theClass.contains("Anastasiia Shalamova"));
			assertEquals(1, theClass.getQtyNames());
			theClass.addStudentName("Adina Bell");
			assertTrue(theClass.contains("Anastasiia Shalamova"));
			assertTrue(theClass.contains("Adina Bell"));
			assertEquals(2, theClass.getQtyNames());
			theClass.addStudentName("Sarah Belsky");
			assertThrows(DuplicateDataException.class, () -> theClass.addStudentName("Sarah Belsky"));
			assertThrows(DuplicateDataException.class, () -> theClass.addStudentName("sarah belsky"));
			theClass.addStudentName("Aviva Bensinger");
			theClass.addStudentName("Elisheva Emmer");
			assertThrows(ArrayIndexOutOfBoundsException.class, () -> theClass.addStudentName("Rochel Cunin"));
		} catch (DuplicateDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testContains() {
		try {
			theClass = new ClassList("MP");
			assertEquals(0, theClass.getQtyNames());
			assertFalse(theClass.contains("Anastasiia Shalamova"));
			theClass.addStudentName("Anastasiia Shalamova");
			assertTrue(theClass.contains("Anastasiia Shalamova"));
			theClass.addStudentName("Adina Bell");
			assertTrue(theClass.contains("Anastasiia Shalamova"));
			assertTrue(theClass.contains("Adina Bell"));
			theClass.addStudentName("Sarah Belsky");
			assertTrue(theClass.contains("Anastasiia Shalamova"));
			assertTrue(theClass.contains("Adina Bell"));
			assertTrue(theClass.contains("Sarah Belsky"));
		} catch (DuplicateDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testRemoveInt() {
		try {
			theClass = new ClassList("MP");
			assertThrows(ArrayIndexOutOfBoundsException.class, () -> theClass.remove(0));
			theClass.addStudentName("Adina Bell");
			assertEquals(1, theClass.getQtyNames());
			theClass.remove(0);
			assertEquals(0, theClass.getQtyNames());
			assertThrows(ArrayIndexOutOfBoundsException.class, () -> theClass.remove(0));
			theClass.addStudentName("Anastasiia Shalamova");
			theClass.addStudentName("Adina Bell");
			theClass.addStudentName("Sarah Belsky");
			theClass.addStudentName("Aviva Bensinger");
			theClass.addStudentName("Elisheva Emmer");
			assertTrue(theClass.contains("Sarah Belsky"));
			theClass.remove(2);
			assertFalse(theClass.contains("Sarah Belsky"));
			assertTrue(theClass.contains("Adina Bell"));
			assertTrue(theClass.contains("Aviva Bensinger"));
			assertEquals(4, theClass.getQtyNames());
			assertThrows(ArrayIndexOutOfBoundsException.class, () -> theClass.remove(4));
			theClass.remove(3);
			assertTrue(theClass.contains("Aviva Bensinger"));
			assertFalse(theClass.contains("Elisheva Emmer"));
			assertEquals(3, theClass.getQtyNames());
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DuplicateDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testRemoveString() {
		try {
			theClass = new ClassList("MP");
			theClass.addStudentName("Anastasiia Shalamova");
			theClass.addStudentName("Adina Bell");
			theClass.addStudentName("Sarah Belsky");
			theClass.addStudentName("Aviva Bensinger");
			theClass.addStudentName("Elisheva Emmer");
			assertEquals(5, theClass.getQtyNames());
			assertTrue(theClass.contains("Sarah Belsky"));
			theClass.remove("Sarah Belsky");
			assertFalse(theClass.contains("Sarah Belsky"));
			assertEquals(4, theClass.getQtyNames());
			assertTrue(theClass.contains("Adina Bell"));
			assertTrue(theClass.contains("Aviva Bensinger"));
			theClass.remove("Elisheva Emmer");
			;
			assertFalse(theClass.contains("Elisheva Emmer"));
			assertTrue(theClass.contains("Aviva Bensinger"));
			assertEquals(3, theClass.getQtyNames());
		} catch (DuplicateDataException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testToString() {
		try {
			theClass = new ClassList("MP");
			theClass.addStudentName("Sarah Belsky");
			theClass.addStudentName("Adina Bell");
			theClass.addStudentName("Aviva Bensinger");
		} catch (DuplicateDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(theClass.toString());
		assertEquals(theClass.toString(), "ClassList [teacherName=" + "MP" + ", names=" + "[" + "Sarah Belsky,"
				+ " Adina Bell," + " Aviva Bensinger," + null + ", " + null + "]" + ", qtyNames=" + 3 + "]");
	}
}