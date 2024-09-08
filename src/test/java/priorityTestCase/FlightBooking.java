package priorityTestCase;

import org.testng.annotations.Test;

public class FlightBooking {
  @Test (priority = -1)
  public void SignIn() {
	  System.out.println("Inside SignIn");
  }
  @Test(priority = 0)
  public void SearchFlight() {
	  System.out.println("Inside SearchFlight");
  }
  @Test(priority = 1)
  public void BookFlight() {
	  System.out.println("Inside BookFlight");
  }
  @Test(priority = 2)
  public void SaveTicket() {
	  System.out.println("Inside SaveTicket");
  }
  @Test(priority = 3)
  public void SignOut() {
	  System.out.println("Inside SignOut");
  }
  
}
