Feature: Create Matching rule
	As a user I need to able to see the result list of match for the Camelot rule criteria. 
	This rules consider the music keys and all artists with musics with the same keys

	Scenario: Process default criterias match
		Given the the 'Camelot' weel rule
		Given the music 'Play it Loud' with artist name 'Marco Carola' and Key 'G maj'
		Given the music 'Play it Loud2' with artist name 'Marco Carola' and Key 'D maj'
		Given the music 'Play it Loud3' with artist name 'Marco Carola' and Key 'E min'
		Given the music 'Play it Loud4' with artist name 'Marco Carola' and Key 'C min'
		Given the music 'Play it' with artist name 'Marco Carola2' and Key 'C min'		
		When I execute the rule for artist name 'Marco Carola'
		Then the list contains '3' matchs 
		Then the list contains a match with music 'Play it Loud' and 'Play it Loud2'
		Then the list contains a match with music 'Play it Loud' and 'Play it Loud3'
		Then the list contains a match with music 'Play it Loud' and 'Play it Loud4'
		Then the list contains a match with music 'Play it Loud' and 'Play it'
				
	Scenario: Process default criterias match without the same music 
		Given the the 'Camelot' weel rule
		Given the music 'Play it Loud' with artist name 'Marco Carola' and Key 'G maj'
		Given the music 'Play it Loud2' with artist name 'Marco Carola' and Key 'G maj'
		Given the music 'Play it Loud4' with artist name 'Marco Carola' and Key 'C min'
		Given the music 'Play it' with artist name 'Marco Carola2' and Key 'C min'		
		When I execute the rule for artist name 'Marco Carola'
		Then the list contains a match with music 'Play it Loud' and 'Play it Loud2'
		Then the list contains a match with music 'Play it Loud' and 'Play it Loud4'
		Then the list contains a match with music 'Play it Loud' and 'Play it'
		
		Then the list does not contains a matchs with same musics
