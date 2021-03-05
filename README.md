# WalletHubAssignment
This framework automates following two applications. It takes user inputs in corresponding feature file and produces HTML reports as output with screenshots attached to the steps.The tester can also input the browser he/she wants to run. The current version of the framework has only chrome driver added in it. This also can be extended to support other browsers by including respective drivers in future.

-Facebook:
The following test steps are automated using the framework.
	Step 1: Opens facebook application 
	Step 2: Enter Credentials- The tester should input username password to login to application in feature file.
	Step 3: Click on add status in home page
	Step 4. Enter status message and click post button- Here the tester can enter status message he/she wants to post


Inputs:
1.	URL- Facebook URL
2.	Browser- Name of browser to run test (eg. chrome)
3.	Username- Facebook username
4.	Password: Facebook Password
5.	Message: Status message to be posted on facebook



-WalletHub:
The following steps are automated using framework.
	Step 1: Launch Wallet Hub application
	Step 2: Hover over fourth star and click on fourth star in Reviews sections of the page
	Step 3: Select a product from the dropdown
	Step 4: Enter the review post
	Step 5: Click on the submit button
	Step 6: Click on the LOgin Tab to post the review
	Step 7: Enter Credentials
	Step 8: Click on Login Button
	Step 9: Verify the review posted in the profile page


Inputs:
1.	URL- Wallet HuB URL
2.	Browser- Name of browser to run test
3.	Product- Name of product to be reviewed
4.	Review Text- Review to be posted
5.	Username - username (registered)
6.	Password- password


Language Used: Java
Tools/Framework Used: 
1.	Selenium Webdriver
2.	Extent Reports
3.	Cucumber
4.	Junit
5.  Maven

Output Reports:
           /HTML Reports/
