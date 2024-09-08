package dataProviderInTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataSupplier2D {

	@DataProvider (name="DataDrive")
	public Object[][] dataSource() {
		Object [][]obj=new Object[][] {
				{"test","QA"},
				{"Automation",123},
				{'B',569}};
		return obj;
	}
	@Test (dataProvider="DataDrive")
	public void driveMethod(Object s1,Object s2) {
		System.out.print(s1);
		System.out.print(":");
		System.out.print(s2);
		System.out.println();
	}
}
