import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdminTest {

	@Test
	void testToString() {
		User u1 = new User ("Pat", "123");
		User u2 = new User ("Pat","123");
		User u3 = new User ("Tom", "124");
		assertEquals(u1.toString(),u2.toString());
		assertNotEquals(u1.toString(), u3.toString());
	}

	@Test
	void testLogin() {
		Admin a1 = new Admin("Pat", "123", true, "1");
		assertTrue(a1.usernameMatch("Pat"));
		assertTrue(a1.passwordMatch("123"));
		assertTrue(a1.employeeIDMatch("1"));
	}

	@Test
	void testAdmin() {
		Admin a1 = new Admin("Pat", "123", true, "1");
		assertTrue(a1.usernameMatch("Pat"));
		assertTrue(a1.passwordMatch("123"));
		assertTrue(a1.employeeIDMatch("1"));
	}

	@Test
	void testEmployeeIDMatch() {
		Admin a1 = new Admin("Pat", "123", true, "1");
		assertTrue(a1.usernameMatch("Pat"));
		assertTrue(a1.passwordMatch("123"));
		assertTrue(a1.employeeIDMatch("1"));
	}

}
