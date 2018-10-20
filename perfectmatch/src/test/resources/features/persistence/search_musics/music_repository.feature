Feature: Search musics in the DAO Mongo repository
  I need to be able show the repository of musics

  Scenario: Search for Latmun - Please Stop (Original Mix) in Music Dao
    Given music repository
    When I get music with name 'Please Stop (Original Mix)'
    Then music should contains artist name 'Latmun'
    Then music should contain id