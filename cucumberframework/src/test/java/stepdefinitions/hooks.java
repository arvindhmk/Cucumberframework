
package stepdefinitions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class hooks extends base
{

	@After
	public void teradown(Scenario scenario) throws IOException
	{
		
		if(scenario.isFailed())
		{
				
			final byte[] scrnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(scrnshot, "image/png");
					
		}


		driver.close();
	}
}


