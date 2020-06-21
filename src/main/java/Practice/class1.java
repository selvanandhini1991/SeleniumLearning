package Practice;

import org.testng.annotations.Test;

public class class1 extends demo{
//	componentname ="Marigold";
	@Test
	public void test() {
		System.out.println("am inside test "+ componentname);
	}
	
	@Test
	public void test1() {
		componentname ="lotus";
		System.out.println("am inside test1 "+ componentname);
	}
}
