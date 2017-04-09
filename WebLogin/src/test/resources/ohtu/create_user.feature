Feature: A new user accon can be created if a proper unused username and password are given

  Scenario: creation succesful with corret username and password
    Given new user is selected
    When new username "takkutukka" and password "1Aklöjdfl2jkdkljödklj" are given
    Then user is created and logged in

  Scenario: creation fails with too short username and valid password
    Given new user is selected
    When new username "w" and password "1aklö2ölfkjdaökljdffdaf" are given
    Then user is not created and error "username should have at least 3 characters" is reported

  Scenario: creation fails with correct username and too short password
    Given new user is selected
    When new username "villasukka" and password "123fe" are given
    Then user is not created and error "password should have at least 8 characters" is reported

  Scenario: creation fails with correct username and password consisting of letters
    Given new user is selected
    When new username "villasukka" and password "aaaaaaaaaaa" are given
    Then user is not created and error "password can not contain only letters" is reported

  Scenario: creation fails with already taken username and valid password
    Given new user is selected
    When new username "pekka" and password "123fAkdkdkkakdkdke" are given
    And new user is again selected
    And new username "pekka" and password "123fAkdkdkkakdkdke" are given
    Then user is not created and error "username is already taken" is reported

  Scenario: user can login with successfully generated account
    Given user with username "liisa" with password "salainen1" is succesfully created
    And login is selected
    When correct username "liisa" and password "salainen1" are given
    Then user is logged in

  Scenario: user can not login with account that is not succesfully created
    Given user with username "aa" and password "bad" is unsuccesfully created
    And login is selected
    When incorrect username "aa" and incorrect password "bad" are given
    Then user is not logged in and error message is given
