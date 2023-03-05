#Author: Jesus Dorado C
@Regresion
  Feature: Automation services restful-booker

    As a user
    I need to automate the following services CreateBooking, GetBooking, UpdateBooking.
    to verify its correct operation
    Background:
      Given that jesus requires to consume a service

    @Cp01
    Scenario Outline: CreateBooking and GetBooking successfully.

      When he performs the creation of a reservation
      |firstname|lastname|totalprice|depositpaid|checkin    |checkout  |additionalneeds|
      |<firstname>|<lastname>|<totalprice>|<depositpaid>|<checkin>    |<checkout>  |<additionalneeds>|
      And verify bookingid and <statusCode>
      And the Query the registered reservation
      And he verifies that the consulted data vs the registered data
        |firstname|lastname|totalprice|depositpaid|checkin    |checkout  |additionalneeds|
        |<firstname>|<lastname>|<totalprice>|<depositpaid>|<checkin>    |<checkout>  |<additionalneeds>|

      Examples:
        |firstname|lastname|totalprice|depositpaid|checkin    |checkout  |additionalneeds|statusCode|
        |Boruto   |Next    |111       |true       |2018-01-01 |2019-01-01|Breakfast      |200       |

    @Cp02
    Scenario Outline: UpdateBooking successfully.

        When the generates token with <username> and <password>
        And updates the reservation with <bookingId>
          |firstname|lastname|totalprice|depositpaid|checkin    |checkout  |additionalneeds|
          |<firstname>|<lastname>|<totalprice>|<depositpaid>|<checkin>    |<checkout>  |<additionalneeds>|
        Then he verifies that the data is updated correctly
          |firstname|lastname|totalprice|depositpaid|checkin    |checkout  |additionalneeds|
          |<firstname>|<lastname>|<totalprice>|<depositpaid>|<checkin>    |<checkout>  |<additionalneeds>|

        Examples:
          |firstname|lastname|totalprice|depositpaid|checkin    |checkout  |additionalneeds|statusCode|bookingId|username|password|
          |Boruto   |Next    |111       |true       |2018-01-01 |2019-01-01|Breakfast      |200       |799     |admin   |password123|


