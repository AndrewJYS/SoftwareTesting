package st;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestBill {
	private int a;
	private boolean result;
	private Bill b;
	
	public TestBill(int a, boolean result) {
		this.a = a;
		this.result = result;
	}
	
	@Before
	public void setUp() {
		b = new Bill();
	}
	
	@Parameters
	public static Collection<Object[]> Values(){
		return Arrays.asList(new Object[][]{{0,false},{83,true},{4,false}});
	}
	
	@Test
	public void Test() {
		assertTrue("Test", result == b.canTakeOut(a));
	}
	
}
