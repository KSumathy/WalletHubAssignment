#Author:  Sumathy K
#Description: WalletHub Assignment for Senior Automation QA Engineer

Feature: Feature for assignment scenarios - WalletHub
  

  @assignment_2 @assignment
  Scenario Outline: Submit Review and Verify review posted.
    Given Open Wallethub using "<URL>" in "<Browser>"
    And I click on fourth rating star
    Then select product as "<product>"
    And write review "<review>"
    And click on submit button
    Then click on login tab
    And enter "<username>" and "<password>"
    And click login button    
    Then verify message "<review>" is posted
    
 
    Examples: 
      |Browser| URL  | product | review  |username|password|
     	|chrome | http://wallethub.com/profile/test_insurance_company/ | Health Insurance	| Testing New Testing Purpose New Purpose New Purpose Testing Services Services In Frame Testing Purpose Testing Purpose Testing Purpose Testing Purpose Testing Purpose Testing Testing Testing Purpose Testing Purpose |sumathy1991@gmail.com|Automation@123|
      