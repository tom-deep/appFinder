import static org.junit.Assert.*;

import org.junit.Test;

public class appTest {

	@Test
	public void testAppStringString() {
		app a1 = new app("instagram", "facebook");
		assertEquals(a1.toString(), "App name: instagram App Developer: facebook");
	}

	@Test
	public void testAppApp() {
		app a1 = new app("instagram", "facebook");
		app a2 = new app(a1);
		assertEquals(a1.toString(), a2.toString());
	}

	@Test
	public void testGetName() {
		app a1 = new app("instagram", "facebook");
		assertEquals("instagram", a1.getName());
	}

	@Test
	public void testSetName() {
		app a1 = new app("google", "facebook");
		a1.setName("instagram");
		assertEquals("instagram", a1.getName());
	}

	@Test
	public void testGetDeveloper() {
		app a1 = new app("instagram", "facebook");
		assertEquals("facebook", a1.getDeveloper());
	}

	@Test
	public void testSetDeveloper() {
		app a1 = new app("instagram", "tom");
		a1.setDeveloper("facebook");
		assertEquals("facebook", a1.getDeveloper());
	}

	@Test
	public void testToString() {
		app a1 = new app("instagram", "facebook");
		assertEquals(a1.toString(), "App name: instagram App Developer: facebook");
	}

}
