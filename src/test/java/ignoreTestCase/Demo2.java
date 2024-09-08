package ignoreTestCase;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
@Ignore
public class Demo2 {
	@Ignore
  @Test
  public void TC006() {
	  System.out.println("inside TC006");
  }
  @Test
  public void TC007() {
	  System.out.println("inside TC007");
  }
  @Test
  public void TC008() {
	  System.out.println("inside TC008");
  }
  @Ignore
  @Test
  public void TC009() {
	  System.out.println("inside TC009");
  }
  @Test
  public void TC010() {
	  System.out.println("inside TC010");
  }
  
}
