package stepdefinitions;

import cucumber.api.java.After;

public class hooks extends base
{

	@After
	public void teradown()
	{
		driver.close();
	}
}
