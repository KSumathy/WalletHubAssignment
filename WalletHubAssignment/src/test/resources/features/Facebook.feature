#Author:  Sumathy K
#Description: WalletHub Assignment for Senior Automation QA Engineer

Feature: Feature for assignment scenarios - Facebook
  

  @assignment_1 @assignment
  Scenario Outline: Login to Facebook and Post a status message.
    Given Open facebook using "<URL>" in "<Browser>"
    And Enter "<username>" and "<password>"
    And I click on Login button
    Then post status message "<message>"
 
    Examples: 
      |Browser| URL  | username | password  |message|
     	|chrome | https://www.facebook.com/ |facebook_username	| facebook_password | Hello |
      
