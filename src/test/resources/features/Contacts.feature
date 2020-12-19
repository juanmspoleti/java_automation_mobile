@Smoke @Contacts
Feature: As a potential client i want to interact with the Contacts functionalities

  @Bug
  Scenario Outline: The user logs in successfully into the app
    Given The app is loaded correctly
    When The user do the login process with '<email>' and '<password>'
    And The user sorts by first name in home view
    Then The contacts are sorted by last name

    Examples:
      | email            | password |
      | mati@brubank.com | m.1234   |

  @Bug
  Scenario Outline: The user logs in successfully into the app
    Given The app is loaded correctly
    When The user do the login process with '<email>' and '<password>'
    And The user sorts by first name in home view
    Then The contacts are sorted by first name

    Examples:
      | email            | password |
      | mati@brubank.com | m.1234   |



