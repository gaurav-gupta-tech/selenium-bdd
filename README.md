How to Create?
1. Java Development Kit (JDK)
Download and install JDK
Setting the system variables -JAVA_HOME

2 .Maven
Download Maven as your build tools
Extract downloaded maven into your current or random directory
Adding maven to the environment path
Verify your maven installation using mvn -version in your Terminal
See the output of Maven version


3. Intellij IDEA or Any other IDE of your choice 
Download and install your IDE using Intellij IDEA or etc.
Open your IDE that installed
Create new project using Maven Project
Select File, New, Project...
New Project window opened
Select Maven, Select Project SDK using dropdown list, Next
Fill the field in Group Id, Artifact Id, Version, then Next
Edit some field if needed, Finish
Default Maven Project should be like this


How to Execute?
1. Run the Test
create a test account for your use in - http://automationpractice.com/ 
and replace with existing email & credentials and 
Run your test using mvn install or mvn verify from Terminal after cloning this repo.
2. Test Result
See the result inside target/cucumber-reports/report.html folder that automatically generated after finished the test execution
Open html file in your browser
Or you can create your result view using json file inside target/cucumber-reports
Some sample of test results 


![image](https://user-images.githubusercontent.com/75585457/111890791-db510180-89e4-11eb-9869-8c863704accf.png)
![image](https://user-images.githubusercontent.com/75585457/111890823-33880380-89e5-11eb-9c3c-cbc4721267dd.png)
![image](https://user-images.githubusercontent.com/75585457/111890835-574b4980-89e5-11eb-83ab-586abb930e21.png)
![image](https://user-images.githubusercontent.com/75585457/111890862-7944cc00-89e5-11eb-9a3b-f0facdb9c9a5.png)
