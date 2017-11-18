# Intellect_design_rest

This is spring boot rest project
I created below folder structure
  - rest controller
  - models
  - exception handler dto
  - service class
  - Spring boot Application class


Rest operaration to perform:
- createUser
  POST
  http://localhost:8080/saveUser
  Request body:
  	{
		"id": "1234",
		"fName": "Divyesh",
		"lName": "Chauhan",
		"email": "dc@gmail.com",
		"pinCode": 12345,
		"birthDate": "02-MAR-1980"
	}				
- updateUser
POST
  http://localhost:8080/updateUser/1234
  Request body:
  	{
		"id": "1234",
		"fName": "",
		"lName": "",
		"email": "",
		"pinCode": 12345,
		"birthDate": "02-MAR-1980"
	}				

- deleteUser
DELETE
http://localhost:8080/deleteUser/1234
