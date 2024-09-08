package groupingInTestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Group1 {
  @Test (groups= {"smoke","sanity"})
  public void TC001() {
	  System.out.println("inside TC001");
  }
  @Test (groups= {"sanity"})
  public void TC002() {
	  System.out.println("inside TC002");
  }
 
  @Test(groups= {"smoke","regression"})
  public void TC003() {
	  System.out.println("inside TC003");
  }
  @Test (groups= {"regression","sanity"})
  public void TC004() {
	  System.out.println("inside TC004");
  }
  @Test (groups= {"smoke","sanity"})
  public void TC005() {
	  System.out.println("inside TC005");
  }
  
}
