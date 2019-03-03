Feature: Create an artist
  I need to be able create an artist

  Scenario: Create Marco Carola artist
    Given the artist name 'Marco Carola' deleted
    Given the artist name 'Marco Carola' 
    When I create the artist
    Then the artist is create with an unique identifier
    Then the artist name is 'Marco Carola'
      
   Scenario: Create 'Marco Carola' artist
    Given the artist name 'Marco Carola' created
    When I create the artist
    Then the result is not created
    Then the reason is Artist Name 'Marco Carola' already exists
      
 