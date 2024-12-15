# 1.Create Feature ( Feature: )
# Describe the overall *purpose* of the feature and add a self-explained description

# 2. Scenario 1: Adding a Duplicate Present:
# Start with a list of presents that already contains specific items. ( I added Present ( "Kindle", "E-reader by Amazon" ))
# Test the behavior when trying to add a present with the same name as one that already exists.
# Ensure the system provides an error message indicating the present already exists.

# 3. Scenario 2: Adding a Present with an Empty Name:
#Attempt to add a new present with an empty string as the name and a valid description.
#The system should reject the operation and return an error stating that the name cannot be null or empty.

# 4. Scenario 3: Removing a Non-Existent Present:
# Use a list that includes several valid presents. ( I added Present ( "Nintendo Switch", "Portable gaming console" ))
# Test the behavior when trying to remove a present that is not in the list.
# Verify that the system raises an appropriate error indicating the present could not be found.