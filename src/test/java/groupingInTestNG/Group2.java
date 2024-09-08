package groupingInTestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
public class Group2 {

  @Test (groups= {"smoke","weekly"})
  public void TC006() {
	  System.out.println("inside TC006");
  }
  @Test(groups= {"sanity"})
  public void TC007() {
	  System.out.println("inside TC007");
  }
  @Test(groups= {"regression","sanity"})
  public void TC008() {
	  System.out.println("inside TC008");
  }
  @Test(groups= {"smoke","weekly"})
  public void TC009() {
	  System.out.println("inside TC009");
  }
  @Test(groups= {"smoke","sanity"})
  public void TC010() {
	  System.out.println("inside TC010");
  }
  
}
