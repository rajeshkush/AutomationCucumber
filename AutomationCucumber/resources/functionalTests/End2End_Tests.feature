Feature: Automated End2End Tests
Description: The purpose of this feature is to test one way train booking.
 
Scenario Outline: Customer search a ticket for source to destination with valid data via scenario
	Given user is on Home Page
	And enter "From" value "<From>" on Home Page
	And enter "To" value "<To>" on Home Page
	And click on "Via/Avoid" on Home Page
	And enter "Via" value "<Via>" on Home Page
	And click on "One Way" on Home Page
	And enter "outDate" value "<OutDate>" on Home Page
	And enter "Leaving At Hour" value "<Hour>" on Home Page
	And enter "Leaving At Min" value "<Min>" on Home Page
	And click on "Get Ticket" on Home Page
	And Verify "<Date>" "<Time>" and "<Price>" on Home Page
Examples:
	|From|To|Via|OutDate|Hour|Min|Date|Time|Price|
	|Paris|München|Karlsruhe Hbf|25-Aug-19|11|45|15|10:55|$223.51|
	
	
Scenario Outline: Customer search a ticket for source to destination with valid data avoid scenario
	Given user is on Home Page
	And enter "From" value "<From>" on Home Page
	And enter "To" value "<To>" on Home Page
	And click on "Via/Avoid" on Home Page
	And enter "Avoid" value "<Via>" on Home Page
	And click on "One Way" on Home Page
	And enter "outDate" value "<OutDate>" on Home Page
	And enter "Leaving At Hour" value "<Hour>" on Home Page
	And enter "Leaving At Min" value "<Min>" on Home Page
	And click on "Get Ticket" on Home Page
	And Verify "<Date>" "<Time>" and "<Price>" on Home Page
Examples:
	|From|To|Via|OutDate|Hour|Min|Date|Time|Price|
	|Paris|München|Karlsruhe Hbf|25-Aug-19|11|45|15|10:55|$223.51|
	
	
Scenario Outline: Customer search a ticket for source to destination with invalid data
	Given user is on Home Page
	And enter "From" value "<From>" on Home Page
	And enter "To" value "<To>" on Home Page
	And click on "Via/Avoid" on Home Page
	And enter "Via" value "<Via>" on Home Page
	And click on "One Way" on Home Page
	And enter "outDate" value "<OutDate>" on Home Page
	And enter "Leaving At Hour" value "<Hour>" on Home Page
	And enter "Leaving At Min" value "<Min>" on Home Page
	And click on "Get Ticket" on Home Page
	And verify the error message value "<Expected>" on Home Page
Examples:
	|From|To|Via|OutDate|Hour|Min|Expected|
	|Paris|Paris|Bruxelles|25-Aug-19|11|45|Your destination station cannot be the same as origin station|
	|Paris|Berlin|Paris|28-Aug-19|11|45|Your via station cannot be the same as origin station|
	
	
	