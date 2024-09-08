package dataProviderInTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataSupplier {

	@DataProvider (name="DataDrive")
	public Object[] dataSource() {
		Object []obj=new Object[] {"test","QA","Automation",123};
		return obj;
	}
	@Test (dataProvider="DataDrive")
	public void driveMethod(Object s1) {
		System.out.println(s1);
	}
}
