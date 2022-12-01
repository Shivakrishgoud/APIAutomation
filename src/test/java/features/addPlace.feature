Feature: Validating place Apis

  Scenario: Verify if place is being added Successfully Added using Add place Api
    Given Add place payload
    When user calls "AddplaceApi" with post http Request
    Then The Api call is success with status code 200
    And "status" in response body is "ok"
    And "scope" in response body is "App"
  