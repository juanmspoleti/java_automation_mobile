@Login
Feature: As a potential client i want to interact with the Login functionalities

  @Smoke
  Scenario Outline: The user logs in successfully into the app
    Given The app is loaded correctly
    When The user do the login process with '<email>' and '<password>'
    Then Home view is displayed

    Examples:
      | email            | password |
      | mati@brubank.com | m.1234   |
    @Bug
    Examples:
      | email            | password |
      | gaby@brubank.com | g.1234   |

  Scenario Outline: The user tries to log in into the app with invalid data
    Given The app is loaded correctly
    When The user do the login process with '<email>' and '<password>'
    Then The message '<message>' is displayed in login view

    @Bug
    Examples:
      | email               | password | message |
      | invalid@brubank.com | m.1234   |         |
    Examples:
      | email            | password | message             |
      |                  |          | Usuario requerido   |
      |                  | g.1234   | Usuario requerido   |
      | mati@brubank.com | g.1234   | Password incorrecta |
      | mati@brubank.com |          | Password requerida  |
