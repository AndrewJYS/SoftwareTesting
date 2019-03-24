package tju.scs.jys.Prime;

import org.junit.*;

public class TestPrime {
    private PrintPrimes p;
    
	public TestPrime() {
		
	}
	
    @Before
    public void setUp(){
    	 p=new PrintPrimes();
    }
    
    @Test
    public void testPrintPrimes(){
         p.printPrimes(1); 
         p.printPrimes(5);         
    }

}
