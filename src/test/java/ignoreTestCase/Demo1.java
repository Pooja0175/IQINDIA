package ignoreTestCase;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Demo1 {
  @Test
  public void TC001() {
	  System.out.println("inside TC001");
  }
  @Test
  public void TC002() {
	  System.out.println("inside TC002");
  }
  @Ignore
  @Test
  public void TC003() {
	  System.out.println("inside TC003");
  }
  @Test
  public void TC004() {
	  System.out.println("inside TC004");
  }
  @Test
  public void TC005() {
	  System.out.println("inside TC005");
  }
  
}
