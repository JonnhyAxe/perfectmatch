Feature: Create Matching rule
	As a user I need to able to create rules to be used for matching purposes
	
	Scenario: Create Key rule
		Given the all criterias 
		When I create the default rule
		Then the rule contains ArtistName criteria
		Then the rule contains Key criteria

	Scenario: Create Camelote rule
		Given the all criterias 
		When I create the Camelote rule
		Then the rule contains ArtistName criteria
		Then the rule contains Key criteria
		Then the rule contains Camelot criteria
		
	Scenario: Create Style rule
		Given the all criterias 
		When I create the Style rule
		Then the rule contains Style criteria
		
	Scenario: Create Remixer rule																																																																																																																																																																																																									aqw	fault rule
		Given the all criterias 
		When I create the Remixer rule
		Then the rule contains 		
		
	Scenario: Create Record Label Name rule																																																																																																																																																																																																									aqw	fault rule
		Given the all criterias 
		When I create the default rule
		Then the rule contains ArtistName
		Then the rule contains Key	