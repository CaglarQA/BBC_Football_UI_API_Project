@test
Feature:As a QA, I would like to verify all negative scenarios for login

  @negativeLogin
  Scenario Outline: Select ‘Sign in’, and enter as many negative scenarios as possible. Verify that a error message is displayed and the text that it  contains is as expected.
    Given user lands on "Homepage" page
    When user clicks sign in link
    And user types "<keyword>" into input box and "<submitAction>"
    Then user should see "<errorMsg>"

    Examples:
      | keyword                                                      | submitAction | errorMsg                                                                                |
      |                                                              | enter        | Something's missing. Please check and try again.                                        |
      |                                                              | click        | Something's missing. Please check and try again.                                        |
      | wrongUserName                                                | enter        | We don’t recognise that email or username. You can try again or register for an account |
      | wrongUserName                                                | click        | We don’t recognise that email or username. You can try again or register for an account |
      | wrongEmail@wrongmail                                         | enter        | Sorry, that email doesn’t look right. Please check it's a proper email.                 |
      | wrongEmail@wrongmail                                         | click        | Sorry, that email doesn’t look right. Please check it's a proper email.                 |
      | wrongEmail@wrongmail.com                                     | enter        | We don’t recognise that email or username. You can try again or register for an account |
      | wrongEmail@wrongmail.com                                     | click        | We don’t recognise that email or username. You can try again or register for an account |
      | ab ac                                                        | enter        |Usernames can only include... Letters, numbers and these characters: ?/\|}{+=_-^~`%$#              |
      | ab ac                                                        | click        | Usernames can only include... Letters, numbers and these characters: ?/\|}{+=_-^~`%$#              |
      | a                                                            | enter        | Sorry, that username's too short. It needs to be at least two characters.               |
      | a                                                            | click        | Sorry, that username's too short. It needs to be at least two characters.               |
      | tooLongUserNametooLongUserNametooLongUserNametooLongUserName | enter        | Sorry, that username's too long. It can't be more than 50 characters.                   |
      | tooLongUserNametooLongUserNametooLongUserNametooLongUserName | click        | Sorry, that username's too long. It can't be more than 50 characters.                   |




