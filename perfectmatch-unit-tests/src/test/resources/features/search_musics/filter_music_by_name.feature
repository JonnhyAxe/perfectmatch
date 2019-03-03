Feature: Search musics in the repository
  I need to be able show the repository of musics

  Scenario: Search for Latmun - Please Stop (Original Mix)
    Given A complete fetch of music repository
    When I have a successfully response
    Then music number '0' should contains artist name 'Latmun'
    Then music number '0' should contains artist Music name 'Please Stop (Original Mix)'
  
  Scenario: Search for Latmun - def (Original Mix)
    Given A complete fetch of music repository
    When I have a successfully response
    Then music number '1' should contains artist name 'Latmun'
    Then music number '1' should contains artist Music name 'def (Original Mix)'
 
   Scenario: Search for Latmun - Please Stop (Original Mix)XPTO
    Given A complete fetch of music repository
    When I have a successfully response
    Then music number '2' should contains artist name 'LatmunXPTO'
    Then music number '2' should contains artist Music name 'Please Stop (Original Mix)XPTO'
       