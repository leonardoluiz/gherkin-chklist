# gherkin-chklist
## A basic checklist generator for Gherkin feature files (Cucumber).

This project is a POC for generation of artifacts based on Gherkin file format.
Given a .feture file a Excel (xls) worksheet is created.

*You will need JDK 8.*

##Usage:

* Clone:	$ git clone https://github.com/leonardoluiz/gherkin-chklist.git
* Bluid:	$ cd gherkin-chklist
		$ mvn clean package
* Run:	$ java -jar target/ghklist.jar  sample-adding.feature adding.xls

###sample-adding.feature:

<pre>
This feature is relative to adding numbers

  Scenario: Add two positive numbers

    Given the input "1 + 1"
    When and calculator is run
    Then the output should be "2"
    
  Scenario: Add two negative numbers

    Given the input "-1 + -1"
    When and calculator is run
    Then the output should be "-2"    

</pre>
###adding.xls:

![Example output](https://cloud.githubusercontent.com/assets/865039/7125130/ca9ff3b6-e204-11e4-8eb5-86c657ac2159.png)


###For reference: 
https://github.com/cucumber/cucumber/wiki/Feature-Introduction
