package Game;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class LogicTest {
	private static Logic logic = new Logic();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Ignore
	public void testGetWorld() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testSetWorld() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetNeighbors() {
		int n,n1;
		boolean world[][]=new boolean[3][3];
		world[0][0]= false;
		world[0][1]= false;
		world[0][2]=true;
		world[1][0]=true;
		world[1][1]=true;
		world[1][2]=false;
		world[2][0]=false;
		world[2][1]=false;
		world[2][2]=true;
		n=logic.getNeighbors(1, 1);
		assertEquals(3,n);
		world[0][0]=false;
		world[0][1]=true;
		world[0][2]=false;
		world[1][0]=true;
		world[1][1]=true;
		world[1][2]=false;
		world[2][0]=false;
		world[2][1]=false;
		world[2][2]=false;
		n=logic.getNeighbors(0, 1);
		assertEquals(2,n);
		world[0][0]=false;
		world[0][1]=true;
		world[0][2]=true;
		world[1][0]=true;
		world[1][1]=true;
		world[1][2]=false;
		world[2][0]=false;
		world[2][1]=false;
		world[2][2]=false;
		n=logic.getNeighbors(0, 2);
		assertEquals(2,n);
	}
		
	

	@SuppressWarnings("deprecation")
	@Test
	public void testCellStateChange() {
		boolean world[][] = { { false, false, false, true, false, false, false, false, false, false },
				{ false, false, true, false, false, false, false, true, false, false },
				{ true, true, false, false, true, false, true, false, false, false },
				{ false, true, false, false, false, false, false, true, false, false },
				{ false, false, true, false, true, false, true, false, true, true },
				{ false, false, false, true, false, false, false, false, false, false },
				{ true, true, false, false, false, false, false, true, false, false },
				{ false, false, false, true, false, false, false, true, false, true },
				{ true, false, false, true, false, false, true, false, false, false },
				{ false, true, false, false, false, true, false, true, false, false } };
		logic.setWorld(world);
		boolean worldchange[][] = { { false, false, false, false, false, false, false, false, false, false },
				{ false, true, true, false, false, false, false, false, false, false },
				{ true, false, true, true, false, false, false, false, false, false },
				{ false, true, false, false, false, false, false, true, true, true },
				{ false, false, true, true, true, false, false, true, false, true },
				{ false, true, false, true, true, false, false, false, true, false },
				{ true, true, false, true, false, false, false, true, false, false },
				{ true, false, false, true, true, false, true, true, true, false },
				{ true, true, false, true, false, false, false, false, true, false },
				{ true, true, true, false, false, false, false, false, false, false } };
		boolean copy[][] = logic.cellStateChange();

		assertEquals(worldchange, copy);
		boolean world1[][] = { { false, true, false, true, false, false, true, false, false, false },
				{ false, false, true, false, true, false, true, true, false, false },
				{ true, true, false, false, true, false, true, false, false, false },
				{ false, true, false, false, false, false, false, true, false, false },
				{ false, false, true, false, true, false, true, false, true, true },
				{ false, true, false, true, false, false, false, false, false, false },
				{ true, true, false, true, false, false, false, true, false, false },
				{ false, false, false, true, false, false, false, true, false, true },
				{ true, false, false, true, false, true, true, false, false, false },
				{ false, true, false, false, false, true, false, true, false, false } };
		logic.setWorld(world1);
		boolean worldchange1[][] = { { false, false, false, true, false, true, true, true, false, false },
				{ false, true, true, false, true, false, false, true, false, false },
				{ true, false, true, false, false, false, true, true, true, false },
				{ false, true, true, false, false, true, false, false, false, true },
				{ false, false, false, true, true, true, true, false, true, true },
				{ true, true, false, true, false, true, false, true, false, false },
				{ true, true, false, true, false, false, false, true, false, false },
				{ true, false, false, true, false, false, false, true, true, false },
				{ true, true, false, false, true, true, false, true, false, false },
				{ true, true, false, false, true, true, false, false, false, false } };
		boolean copy1[][] = logic.cellStateChange();
		assertEquals(worldchange1, copy1);
		boolean world2[][] = { { false, true, false, true, false, false, true, false, false, false },
				{ false, false, true, false, true, false, true, true, false, false },
				{ true, true, false, false, true, false, true, false, false, false },
				{ false, true, false, false, false, false, false, true, false, false },
				{ false, false, true, false, true, false, true, false, true, true },
				{ false, true, false, true, false, false, false, false, false, false },
				{ true, true, false, true, false, false, false, true, false, false },
				{ false, false, false, true, false, false, false, true, false, true },
				{ true, false, false, true, false, true, true, false, false, false },
				{ false, true, false, false, false, true, false, true, false, false } };
		logic.setWorld(world1);
		boolean worldchange2[][] = { { false, false, true, true, true, true, true, true, false, false },
				{ false, false, true, false, true, false, false, false, true, false },
				{ false, false, true, false, false, true, true, true, true, true },
				{ false, true, true, false, false, false, false, false, false, false },
				{ true, false, false, true, false, true, true, true, true, false },
				{ false, true, false, true, false, true, false, false, true, false },
				{ true, true, false, true, false, false, true, false, true, true },
				{ false, false, false, true, false, true, false, false, true, true },
				{ true, true, true, false, false, true, false, false, false, false },
				{ true, false, false, false, true, true, false, false, false, false } };
		boolean copy2[][] = logic.cellStateChange();
		assertEquals(worldchange2, copy2);
	}

}
