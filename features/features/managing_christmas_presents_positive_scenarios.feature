# 1.Create Feature ( Feature: )
# Describe the overall *purpose* of the feature and add a self-explained description
# Example:
#Feature: Guess the word
  #The word guess game is a turn-based game for two players.
  #The Maker makes a word for the Breaker to guess. The game
  #is over when the Breaker guesses the Maker's word.

# 2. Scenario 1
# Include a Given step to initialize the gift list with some sample presents.
# Use a table format for readability and clarity when listing presents.
# ( List of presents: Present 1 ("Kindle", "E-reader by Amazon"), Present 2 ("Nintendo Switch", "Portable gaming console"))
#    | name            | description             |
#    | Kindle          | E-reader by Amazon      |
# Add a When step to simulate adding a new present.
# Verify the list contains the added present using a Then step.


# 3. Scenario 2
# Given step text should be identical for the Given ext from the first positive scenario, except for the presents, that will be added
# ( List of presents: Present 1 ("Kindle", "E-reader by Amazon"), Present 2 ("Nintendo Switch", "Portable gaming console"),
#                     Present 3 ("AirPods Max", "AirPods Max – Studio sound, zero distractions."), Present 4 ("PS5", "Next-gen gaming console"))
# Include a When step for removing one or more presents, using a table to list the presents being removed. (Kindle & AirPods Max)
#     | name        |
#     | Kindle      |
# Validate that the removed presents are no longer in the list, while the remaining ones still exist. ( using Then & And keywords)
# And statement for still existing presents should be identical to the then statement in the previous scenario# Example:
# Example:
# Then the gift list should not contain a present with name "<Name2>"
#  And the gift list should not contain a present with name "<Name3>"