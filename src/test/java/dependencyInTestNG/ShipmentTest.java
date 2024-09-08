package dependencyInTestNG;

import org.testng.annotations.Test;

public class ShipmentTest {
	public static String shipmentNo;
	
	@Test (enabled=true)
	public void createShipment() {
		System.out.println("create shipment");
		shipmentNo="123456";
	}
	@Test (dependsOnMethods="createShipment" ,enabled=true)
	public void trackShipment() {
		System.out.println(10/0);
		if(shipmentNo!=null) {
		System.out.println(shipmentNo);
		}
		else {
			System.out.println("shipment exception error");
		}
	}
	@Test (dependsOnMethods={"createShipment","trackShipment"})
	public void cencelShipment() {
		System.out.println("inside cancel shipment");
	}
	
}
