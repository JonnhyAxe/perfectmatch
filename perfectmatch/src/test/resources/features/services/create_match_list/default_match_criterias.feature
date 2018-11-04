Feature: Create Matching rule
	As a user I need to able to see the result list of match for the default rule criteria

	Scenario: Process default criterias match
		Given the the default rule
		Given the music Play it Loud with artist name Marco Carola and Key G maj
		Given the music Play it Loud2 with artist name Marco Carola and Key G maj
		When I execute the rule for artist name Marco Carola
		Then the list contains a match with music Play it Loud and Play it Loud2
		
	Scenario: Process default criterias match without the same music 
		Given the the default rule
		Given the music Play it Loud with artist name Marco Carola and Key G maj
		Given the music Play it Loud2 with artist name Marco Carola and Key G maj
		When I execute the rule for artist name Marco Carola
		Then the list contains a match with music Play it Loud and Play it Loud2
		Then the list does not contains a match with music Play it Loud and Play it Loud
		Then the list does not contains a match with music Play2 it Loud and Play it Loud2