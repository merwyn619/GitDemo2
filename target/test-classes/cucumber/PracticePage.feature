#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Feature testing of Practice Page
  I want to use this template for my feature file

	#Scenario Outline: Positive TC of Practice Page
	#Given I landed on Practice Page
	#When I enter <name2> in Alert text box 
	#And I enter <displayedText2> in HideShow text box
	#Then Positive TC of Practice Page is working as expected
	
	#Examples: 
	#| name2	|	displayedText2 	|
 	#|	Atul	| Jason						|
 	
 	Scenario: Positive TC of Practice Page
 	Given I landed on Practice Page
 	When I verify logo, radiobutton, autoSuggestion, dropdown and checkbox
 	And I verify openWindow, openTab, top, reload and iFrame
 	Then Positive TC of Practice Page is working as expected
 	
