Feature: Get Info from DB
  @HC
  Scenario: Connect to DB and retrieve some Data
    Given  I connect to DB
    When   I execute some query
    And    I get info from query and convert it into JAVA object
    Then   I close the DB connection



  @HC
  Scenario: Connect to DB and retrieve some Data then convert them into JAVA object
    Given  I execute specific query "GETUSERINFOFORSPECIFICLOCATION" and get records
    When   I convert query "GETUSERINFOFORSPECIFICLOCATION" results into Request Model
    And    I convert object into JSON file "customerDetailsRequest"
