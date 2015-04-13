# encoding: utf-8

Feature: Adding

This feature is relative to adding numbers 

  Scenario: Add two positive numbers

    Given the input "1 + 1"
    When and calculator is run
    Then the output should be "2"
    
  Scenario: Add two negative numbers

    Given the input "-1 + -1"
    When and calculator is run
    Then the output should be "-2"    