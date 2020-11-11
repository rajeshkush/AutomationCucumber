Feature: Test Smoke scenario of Facebook
	Scenario: Test Facebook with valid credentails
	Given Open Firefox and start application
	When I provide valid username and valid password
	Then user should be able to login