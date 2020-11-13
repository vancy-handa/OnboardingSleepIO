**Project- Automation Framework for Onboarding Flow of Sleepio**

Technology Used: Java, Selenium, JUnit, Cucumber, Maven  
Framework Used- Behavior Driven Developement(BDD). 

Installation:
git clone https://github.com/vancy-handa/OnboardingSleepIO.git


Tests Covered:
- verified user is navigated to Sleep Score page when clicked on Get Started on Login Page
- verified general error message when clicked on continue without answering the question
- verified specific error message related to the type of question when clicked on continue without answering the question
- verified when None of the Above is selected, all other options selected gets unselected
- verified options are selected based on the type of question i.e. 
  - for multiple option question, multiple choices can be selected. 
  - for drop down question, first option will be selected. 
  - for single choice question, first option will be selected. 
