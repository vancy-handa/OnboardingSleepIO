
Feature: Onboarding process of Sleepio.
Description: Purpose of this test case is to test onboarding process of Sleepio.
 
 
Scenario: User is navigated to sleep score page from Landing page
Given user is on landingPage
When user clicks on Get Started
Then user navigates to sleep score page and Your Sleep Score header is shown

Scenario: Verify Error message when no answer is selected
Given user is on landingPage
When user clicks on Get Started
And navigates to sleep score page 
And selects no answer and clicks on Continue
Then error message is shown

Scenario: Verify specific error message related to type of question when no answer is selected
Given user is on landingPage
When user clicks on Get Started
And navigates to sleep score page 
And clicks on Continue 
Then specific error related to type of question is shown

Scenario: As soon as user selects None Of Above for multiple options question, all other options should be unselected. 
Given user is on landingPage
When user clicks on Get Started
And navigates to sleep score page 
And selects multiple options
And selects None of the Above
Then multiple answers selected previously should be unselected


Scenario: User selects answer to the question
Given user is on landingPage
When user clicks on Get Started
And navigates to sleep score page 
And verifies the type of question and selects answer
Then answer is selected successfully
And clicks on Continue










