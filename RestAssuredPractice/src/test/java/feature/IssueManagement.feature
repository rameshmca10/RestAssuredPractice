Feature: IssueManagement 

Scenario: Create a new Issue 

#Given set the endpoint
#And  set up the basic auth with valid credential
	When send the post request with body as file './data/CreateAnIssue.json' 
	Then verify the status code is 201 
	And  verify the response body contains contentType is 'Json' 
	
Scenario Outline: Create a new issue with 2 set of data 

#Given set the endpoint
#And  set up the basic auth with valid credential
	When send the post request with body as '<jsonFile>' 
	Then verify the status code is 201 
	And  verify the response body contains contentType is 'Json' 
	
	Examples: 
	# rows & column
		|jsonFile|
		# 1 row
		|./data/CreateAnIssue1.json|
		# 2 row
		|./data/CreateAnIssue2.json|