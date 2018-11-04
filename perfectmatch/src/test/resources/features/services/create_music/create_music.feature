Feature: Create an music for a given Artist
	As a user I want to be able to create an music of a given artist name and music style

	Scenario: Create an music with mandatory fields
		Given the music name 'Play it Loud'
		Given the music style 'TECHNO'
		When I create the music for 'Marco Carola' artist
		Then the music is created 
		Then the music contains an id
		Then the music name is 'Play it Loud'
		Then the music style is 'TECHNO'
		Then the music artist name is 'Marco Carola'
	
	Scenario: Create an music with more than one Artist
		Given the music name 'Play it Loud'
		Given the music style 'TECHNO'
		When I create the music with artists:
		| Marco Carola   |
		| Marco Carola2  |
		Then the music is created 
		Then the music contains an id
		Then the music name is 'Play it Loud'
		Then the music style is 'TECHNO'
		Then the music artist name is 'Marco Carola'
				
	Scenario: Create an music without the existing artist
		Given the music name 'Play it Loud'
		Given the music style 'TECHNO'
		When I create the music for 'XPTO' artist
		Then the music is not created
		Then the reason is Artist Name 'XPTO' not found
		
	Scenario: Update music with audio file  
		Given the music name 'Play it Loud'
		Given and the source file provider 'https://www.youtube.com/watch?v=3SdvDZS9MIQ'
		When I add the audio file
		Then the music contains playable audio file
		Then the music contains audio file provider 'https://www.youtube.com/watch?v=3SdvDZS9MIQ'
		
	Scenario: Update music with audio file metadata provider
		Given the music name 'Play it Loud'
		Given the music with audio file with metadata
		When I search for the Key
		Then the result is 'G maj'
		When I search for Energy
		Then the result is '7'
		When I search for Tempo
		Then the result is '127'
		
	Scenario: Update music with remixer and record Label
		Given the music name 'Play it Loud'
		Given remixers names:
			| Marco Carola |
		Given record label name 'Vendetta Records'
		When I update music
		Then the music contains record label 'Vendetta Records'
		Then the music name is 'Play it Loud'
		Then the music style is 'TECHNO'
		Then the music artist name is 'Marco Carola'
		Then the music contains remixer:
			| Marco Carola |
	
