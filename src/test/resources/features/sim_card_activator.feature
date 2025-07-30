Feature: SIM card activation

  Scenario: Successful SIM card activation
    Given a SIM card with ICCID "1255789453849037777" and email "success@example.com"
    When I activate the SIM
    Then the activation response should be success
    And querying the activation by ID 1 should return status "SUCCESS"

  Scenario: Failed SIM card activation
    Given a SIM card with ICCID "8944500102198304826" and email "fail@example.com"
    When I activate the SIM
    Then the activation response should be failure
    And querying the activation by ID 2 should return status "FAILURE"