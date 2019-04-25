import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BubbleSortTest {
	@Test
	public void testBubbleSort() {
		int[] a1 = {2,10,6,-6,-13,15};
		int[] b1 = {-3,-3,4,8,5,8,4,1,0};
		int a2[] = BubbleSort.BubbleSort(a1);
		int b2[] = BubbleSort.BubbleSort(b1);
		int [] t1={-13,-6,2,6,10,15};
		int [] t2={-3,-3,0,1,4,4,5,8,8};
		assertArrayEquals(t1,a2);
		assertArrayEquals(t2,b2);	
	}


}
