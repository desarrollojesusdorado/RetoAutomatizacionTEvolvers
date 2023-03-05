#Author: Jesus Dorado C

Feature: Automation web demo blaze

  As a user
  I need to add products to the shopping cart
  and verify that the total amount to be paid is correct

  @Cp01
  Scenario Outline: Add products successfully

    Given jesus wants to enter the blaze demo site
    When he adds several products to the shopping cart
    |ProductOne         |ProducTwo     |ProductThree       |
    |<ProductOne>         |<ProducTwo>     |<ProductThree>       |
    And the complete purchase
    |name|country|city|creditCard|month|year|
    |<name>|<country>|<city>|<creditCard>|<month>|<year>|
    Then the verifies that the total value is "<totalPrice>"
    And verify the message "Thank you for your purchase!"

    Examples:
      |ProductOne         |ProducTwo     |ProductThree       |name|country|city|creditCard|month|year|totalPrice|
      | HTC One M9        |Iphone 6 32gb | Samsung galaxy s7 |Borutho|Japan|Japan|12345   |Dec  |2022|2290      |
      | Sony xperia z5    |Nexus 6       | Samsung galaxy s6 |Borutho|Japan|Japan|12345   |Dec  |2022|1330      |