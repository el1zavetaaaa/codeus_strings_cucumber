# Task Overview 👓

You will receive a list of strings.<br/>

- Each string corresponds to the part of the customer's address  🎒. 
- There is no granted specific order of the strings in the list 💼.
- However, there is a list of rules how you should work with the address lines 👜.

# How to extract needed information from the list of addresses 👑

**You should extract all the numerics from the lines.** <br/>

You should extract all numerics to a String, if there are more than 1 numeric in the list
 --> they should be separated by a colon. 

**Examples (Input --> Output) :**

- "73 Baker Street" --> "73"
- "73 A Baker Street" --> "73A"
- "73A Baker Street" --> "73A"
- "111 - 113 Baker Street" --> "111-113"
- "Flat 1" "73 Baker Street" --> "1:73"
- "Flat 1A" "73 Baker Street" --> "1A:73"
- "Flat 1.4" "73 Baker Street" --> "1.4:73"
- "Flat 402" "111-113 Baker Street" --> "402:111-113"
- "Flat 1/4" "73A Baker Street" --> "1/4:73A"

*If the first address line starts with **"Flat", "Fl", "Apartment", "Apt"** and is followed by a **single letter**<br/>
--> the letter should be added to the number*<br/>

- "Flat A" "73 Baker Street" --> "73A"