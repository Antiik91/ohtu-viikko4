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