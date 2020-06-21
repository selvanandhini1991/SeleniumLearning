package retryAnalyser;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test {

	@BeforeMethod
	public void beforetest() {
		System.out.println(retryAnalyser.getCounter());
	}

//	@Test(retryAnalyzer = retryAnalyser.class)
	@Test
	public void test1() {
		System.out.println("inside test1");
		Assert.assertTrue(5 > 10);
	}

}
