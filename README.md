# Country/Citizen Simulation

Link to front-end repository: https://github.com/DRMADNESS2004/final_project_frontend.git  
Link to back-end repository: https://github.com/DRMADNESS2004/Final_Project_BackEnd_JWP.git

### Design:

I created a Country entity that has String name, int population and boolean selected. The selected is used to check when the country has been selected. If it has, it'll display the country's population and its citizens. I created a Citizen entity with String name, boolean selected, a Many to One relationship with Country (many citizens can be in one country, if the country is deleted, the citizens inside are deleted, the foreign key is country_id which is the id of the country), a One to One relationship with Job (a citizen can only have one job, if the citizen is deleted, the job is deleted). There's also a Job entity which has String name, int salary, and int weeklyHours. The PossibleCountry entity is only used to store the world's possible countries' names with their population. In the controllers, only responses are returned, never the entity itself. The services take care of the functionality. The repositories extend CrudRepository and define the CRUD operations on the entities. The requests make sure that the fields in the request are valid. The ResourceNotFoundException class extends RunTimeException and is thrown when the id that's being accessed is not found. The controllers process the incoming requests and return the responses based on the URL they are defined.

### End-points documentation for backend:

- **GET /api/possibleCountries**     Gets all possible countries
* **GET /api/countries**     Gets all countries
+ **POST /api/countries**     Adds a new country
- **DELETE /api/countries/:countryId**     Deletes a country based on its id
* **PUT /api/countries/:countryId**     Updates a country based on its id
+ **POST /api/countries/:countryId/citizens**     Adds a new citizen to a country based on its id
- **GET /api/countries/:countryId/citizens**     Gets all citizens of a country based on its id
* **GET /api/citizens**     Gets all citizens
+ **Delete /api/citizen/:citizenId**     Delete a citizen based on its id
- **PUT /api/citizens/:citizenId**     Updates a citizen based on its id