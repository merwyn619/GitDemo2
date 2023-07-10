package rsa.stepDefinition;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rsa.TestComponents.BaseTest;
import rsa.pageobjects.PracticePage;

public class StepDefinitionImpl extends BaseTest {

	public PracticePage pp;
	
	@Given("I landed on Practice Page")
	public void I_landed_on_Practice_Page() throws IOException
	{
		pp=setup();
	}

	/*@When("^I enter name2 (.+) in Alert text box$")
	public void I_enter_name2_in_Alert_text_box(String name2)
	{
		pp.name(name2);
		pp.alert();
		pp.confirm();
		throw new io.cucumber.java.PendingException();
	}
	
	@And("^I enter displayedText2 (.+) in HideShow text box$")
	public void I_enter_displayedText2_in_HideShow_text_box(String displayedText2)
	{
		pp.displayedText(displayedText2);
		pp.hide();
		pp.show();
		throw new io.cucumber.java.PendingException();
	}*/
	
	@When("I verify logo, radiobutton, autoSuggestion, dropdown and checkbox")
	public void I_verify_logo_radiobutton_autoSuggestion_dropdown_and_checkbox()
	{
		pp.logo();
		pp.radio1();
		pp.autoSuggestion();
		pp.selectDropdown();
		pp.selectFromDropdown();
		pp.checkboxOption3();
	}
	
	@And("I verify openWindow, openTab, top, reload and iFrame")
	public void I_verify_openWindow_openTab_top_reload_and_iFrame()
	{
		pp.openWindow();
		pp.getWindowHandles();
		pp.openTab();
		pp.getWindowHandles();
		pp.mouseHover();
	    pp.top();
	    pp.reload();
	    pp.iFrame();
	}
	
	@Then("Positive TC of Practice Page is working as expected")
	public void Positive_TC_of_Practice_Page_is_working_as_expected()
	{
		System.out.println("Positive TC of Practice Page is working as expected");
	}
	
}
