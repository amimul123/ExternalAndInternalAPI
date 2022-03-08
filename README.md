# ExternalAndInternalAPI
1. GET, POST REST API
2. Programmatically call to external API from Controller

# External API Call
1. Send a GET or POST request to the controller, named http://localhost:8081/ExternalToken
2. Controller internally calls an externerl API, named http://localhost:8081/api/AddToken
3. Internally send a  HTTP POST request with requied headers and params (JSON)
4. Fetch the response of POST request (external api) and controller sends back that response to the user

# Rest API
1. api/AddUser (POST) <br/>
Send a json object as follows:
```json
{
    "fName": "new",
    "lName": "hos",
    "gender": "",
    "dob": "2001-10-10",
    "email": "email",
    "addresses": [
        {
            "street": "",
            "houseNo": "",
            "city": "",
            "postCode": "",
            "country": "",
            "type": ""
        }
    ]
}
```
2. api/AddTestUser (POST) <br/>
Create a user internally and save to database
4. api/GetUser/{email} (GET)
5. api/GetAddressByCity/{city} (GET)
6. api/AddToken (POST) <br/>
Send a json object as follows:
```json
{
    "param":
        {
            "auth": "your auth text",
            "email": "example@example.com",
            "origin": "DE"
        }
}
```
7. api/GetToken/{email} (GET)
