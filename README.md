#### The test will create a new user with random created personal data information

#### It uses Cucumber which means that your test class is a feature file

````
Feature: User Create new account

  Scenario Outline: DE - Delete registered customer
    Given new "<legal_entity>" customer is registered

    Examples:
      | legal_entity |
      | DE           |

````

The tests can be executed with the following command:

````
./gradlew cucumber 
````
or run it in your IDE

------------------------------------------------------

#### Class overview for Cucumber test
* `Create_account.feature` is the test class in cucumber it contains all the steps of your test
* `RegistrationSteps.kt` contains all the steps (Given, When, Then) that can be reused for every feature (cucumber)
* `Registration package` contains all classes for registration which will be used in RegistrationSteps.kt
* `TestContext.kt` is a singleton, it saves the information that it will be used during the test
* `RequestMethods.kt` has all functions to do request with rest assured
* `Retry.kt` if the request fails the rerun will try max 3 times to not fail the test
* `Helper.kt` has all the functions that creates random data or other helper functions for the tests
