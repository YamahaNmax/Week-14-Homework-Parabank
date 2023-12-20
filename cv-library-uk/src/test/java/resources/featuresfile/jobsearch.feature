Feature: Job Search Test

  As user I want to search jobs on Cv-Library website

  @test
  Scenario Outline: Verify Job search result using different data set

    Given I am on homepage
    And I accept iFrame
    And I enter "<job title>","<location>","<distance>"
    And I click on more search option
    And I enter "<min salary>","<max salary>","<salary type>","<job type>"
    And I click on find job button
    Then I should able to see the search result "<search result>"

    Examples:
      | job title         | location | distance       | min salary | max salary | salary type | job type  | search result                              |
      | Tester            | Harrow   | up to 5 miles  | 30000      | 500000     | Per annum   | Permanent | Permanent Tester jobs in Harrow            |
      | Automation Tester | London   | up to 15 miles | 5000       | 9500       | Per month   | Permanent | Permanent Automation Tester jobs in London |
      | Project Manager   | Leeds    | up to 7 miles  | 300        | 950        | Per day     | Contract  | Contract Project Manager jobs in Leeds     |
