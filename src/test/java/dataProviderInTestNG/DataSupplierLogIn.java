package dataProviderInTestNG;

import org.testng.annotations.DataProvider;

public class DataSupplierLogIn {
	
	@DataProvider (name="DataDriveLogIn",parallel=true,indices= {0,3,5,4})
	public Object[][] dataSourceLogIn() {
		Object[][]obj=new Object[][] {
			{"jsmith","demo1234"},
			{"jsmit","demo1234"},
			{"jsmith","demo123"},
			{"jsmith","demo1234"},
			{"jsmit","demo1234"},
			{"jsmith","demo123"},
			{"jsmith","demo1234"},
			{"jsmit","demo1234"},
			{"jsmith","demo123"}};
		return obj;
	}
	
}
