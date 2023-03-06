Feature: Add Address 

Scenario Outline: To validate add address functionality
Given user is on login page
When user enter "<username>" and "<password>" and click login button 
Then user clicks on My Account then Address
Then user enter "<firstname>" , "<lastName>" , "<Email>"  , "<cityname>" , "<addressCity>" , "<postalCode>" and "<pNumber>" and click save button
Then user logouts

Examples:
|username|password|firstname|lastName|Email|cityname|addressCity|postalCode|pNumber|
|v21@gmail.com|v12345|venu|sfsfd|v21@gmail.com|New York|edge23-lala street|e100012|7013606325|