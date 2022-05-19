Feature: User Create new account

  Scenario Outline: Delete registered customer
    Given new "<legal_entity>" customer is registered

    Examples:
      | legal_entity |
      | DE           |
