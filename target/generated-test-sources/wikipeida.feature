Feature: Wiki Search Functionality

  @Wiki
  Scenario Outline: Validate Wiki Search
    Given user navigates to "https://www.wikipedia.org"
    When user searches for "<key>" on Wikipedia
    Then user should see "<key>" in the title
    And user should see "<key>" in the url
    And user should see "<key>" in the first heading
    Examples:
      | key        |
      | Elon Musk  |
      | Bill Gates |
      | robert downey jr |
