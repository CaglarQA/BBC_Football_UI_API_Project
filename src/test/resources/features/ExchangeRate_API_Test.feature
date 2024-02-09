@api
Feature:Do the following on the site whose URL is given

  Background: Take Response
  Given Get the Response by making an API query

  Scenario: Verify the HTTP status code 200
    Then Verify status code 200

  Scenario:Count the total number of currencies returned within the response
    When Calculate the Currency in Response
    Then Verify that there are a total 162 currencies

  Scenario: Verify the currency ‘GBP’ is shown within the response
    When Print response
    Then Verify the currency "GBP" is shown within the response




