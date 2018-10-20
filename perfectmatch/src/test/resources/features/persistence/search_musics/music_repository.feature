Feature: Search musics in the DAO Mongo repository
  I need to be able show the repository of musics

  Scenario: Search for Latmun - Please Stop (Original Mix)
    Given music repository
    When I get music with name 'Please Stop (Original Mix)'
    Then music should contain artist name 'Latmun'
    Then music should contain id