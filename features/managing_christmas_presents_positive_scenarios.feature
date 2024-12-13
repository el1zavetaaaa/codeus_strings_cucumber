Feature: Managing Christmas Presents
  As a Santa Claus preparing for Christmas
  I want to manage my list of presents
  So that I can ensure everyone gets the perfect gift

  Scenario: Add a present, that does not exist in a list, successfully
    Given the giftList contains some presents
    When I add a present with name "AirPods Max" and description "AirPods Max – Studio sound, zero distractions."
    Then the gift list should contain a present with the name "AirPods Max"


  Scenario: Firstly remove 1 present, then add another present
    Given the gift list contains a present with name "Toy Car" and description "A remote-controlled car"
    When  I remove a present with name "Lego Set" and description "A colorful building set"
    And   I add a new present with name "iPhone 16 Pro" and description ""Cutting-edge performance with stunning display and camera."
    Then  the gift list should not contain a present with name "Toy Car"
    And   the gift should contain a present named "iPhone 16 Pro"