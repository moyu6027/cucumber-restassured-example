# language: en

@SmokeTest

Feature: Smoke API test

 Scenario: Getting a Guest Token | Registration | Authorization | View Profile

    When we send a request to get a guest token
    Then the server response code 200
    Then the server response contains a guest token

    When we send a request with a guest token to register a new player
    Then the server response code 201
    Then the server's response to the registration request corresponds to the documentation

    When we send an authorization request under the created player
    Then the server response code 200
    Then the server response to the authorization request contains a token
