Feature: Get Info from DB
  @HC
  Scenario: Connect to DB and retrieve some Data
    Given  I connect to DB
    When   I execute some query
    And    I get info from query and convert it into JAVA object
    Then   I close the DB connection