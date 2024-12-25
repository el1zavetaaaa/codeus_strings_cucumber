Feature:  Validations and error handling for managing Christmas presents
  As a Santa Claus preparing for Christmas
  I want the system to handle invalid or duplicate presents
  So that my gift list is reliable and consistent

  Scenario: Adding a duplicate present
    Given the giftList contains some presents:
      | name            | description             |
      | Kindle          | E-reader by Amazon      |
    When I add a present with name "Kindle" and description "Another Kindle"
    Then I should receive an error saying "Present with name Kindle already exists"

  Scenario: Adding a present with an empty name
    When I add a present with name "" and description "Some description"
    Then I should receive an error saying "Present or present name cannot be null/empty."

  Scenario: Removing a present that does not exist
    Given the giftList contains some presents:
      | name            | description             |
      | Nintendo Switch | Portable gaming console |
    When I remove a present with name "PS5"
    Then I should receive an error saying "Present with the name PS5 is not found."