import static org.junit.jupiter.api.Assertions.*;

import java.awt.desktop.UserSessionEvent;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testUser() {
		//fail("Not yet implemented");
		User u1 = new User("Pat", "1234");
		User u2 = new User("Pat","1234");
		assertEquals(u1.toString(), u2.toString());	
	}

	@Test
	void testUsernameMatch() {
		User u1 = new User("Pat","1234");
		assertTrue(u1.usernameMatch("Pat"));
		assertFalse(u1.usernameMatch("pa"));
		assertFalse(u1.usernameMatch("pat"));
	}

	@Test
	void testPasswordMatch() {
		//fail("Not yet implemented");
		User u1 = new User("Pat", "1234");
		assertTrue(u1.passwordMatch("1234"));
		assertFalse(u1.passwordMatch("12"));
		assertFalse(u1.passwordMatch("3213"));
	}

	@Test
	void testLogin() {
		User u1 = new User("Pat","1234");
		assertTrue(u1.usernameMatch("Pat"));
		assertTrue(u1.passwordMatch("1234"));
	}


}
