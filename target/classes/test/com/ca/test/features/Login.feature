Feature: Login To Yahoo
  Test the log in feature and assert that user can see current date in calendar

  Scenario Outline: Successful Login With Excel
    Given I am on the default homepage
    When I click sign in button
    And I Login with credentials given in excel using "<SheetName>" and RowNumber <RowNumber>
    When I navigate to calendar
    Then I confirm the current date

    Examples:
    | SheetName   | RowNumber |
    | Credentials | 0         |

  Scenario Outline: UnSuccessful Login With Excel
    Given I am on the default homepage
    When I click sign in button
    And I insert UserName given in excel using "<SheetName>" and RowNumber <RowNumber>
    Then I confirm error message

    Examples:
      | SheetName   | RowNumber |
      | Credentials | 1         |
      | Credentials | 2         |