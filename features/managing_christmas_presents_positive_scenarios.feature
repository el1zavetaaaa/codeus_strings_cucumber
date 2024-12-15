Feature: Managing Christmas Presents
  As a Santa Claus preparing for Christmas
  I want to manage my list of presents
  So that I can ensure everyone gets the perfect gift

  Scenario: Add a present, that does not exist in a list, successfully
    Given the giftList contains some presents:
      | name            | description             |
      | Kindle          | E-reader by Amazon      |
      | Nintendo Switch | Portable gaming console |
    When I add a present with name "AirPods Max" and description "AirPods Max – Studio sound, zero distractions."
    Then the gift list should still contain a present with the name "AirPods Max"

  Scenario: Remove two items from the gift list successfully
    Given the giftList contains some presents:
      | name            | description                                    |
      | Kindle          | E-reader by Amazon                             |
      | Nintendo Switch | Portable gaming console                        |
      | AirPods Max     | AirPods Max – Studio sound, zero distractions. |
      | PS5             | Next-gen gaming console                        |
    When I remove the following presents:
      | name        |
      | Kindle      |
      | AirPods Max |
    Then the gift list should not contain a present with name "Kindle"
    And the gift list should not contain a present with name "AirPods Max"
    And the gift list should still contain a present with the name "Nintendo Switch"
    And the gift list should still contain a present with the name "PS5"
