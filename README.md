# country-service

Country service includes following sub applications:
 - country-service-backend: Spring boot application server which serves REST Country API interface. Needed country data will be fetched from 3rd party service https://restcountries.eu.
 - country-service-fronted: React application which  gives user interface to get and show needed country data in web browser user interface. UI has to functions: 
    - List all countries get all country list
    - Find method search inputted language and show it for user if it is found or not.


 ## Notes

 Before running and testing Country service, probably you need to have installed:
 - Java 8 (https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
 - maven (https://maven.apache.org/install.html)
 - node.js (https://nodejs.org/en/download/ or https://nodejs.org/en/download/package-manager/)
 
 Build and run procedure only tested with mac OS.  But should able to be done with other operating systems like Windows and Linux variants. 


 ## Run country-service on your local machine

 ### Get source codes
 ```bash
 $ git clone https://github.com/kiisak/country-service.git
 $ cd country-service
 ```

 ### Build and run

#### Backend
```bash
$ cd country-service-backend
$ mvn compile
$ mvn spring-boot:run
```

After that backend will be running on http://localhost:8080/

You can test backend implemented REST API interfaces for example with curl application.

##### Get all countries
```bash
$ curl http://localhost:8080/countries
```

Example response

```json
[{"name":"Afghanistan","country_code":"AF","capital":"Kabul","population":27657145,"flag_file_url":"https://restcountries.eu/data/afg.svg"},{"name":"Åland Islands","country_code":"AX","capital":"Mariehamn","population":28875,"flag_file_url":"https://restcountries.eu/data/ala.svg"},{"name":"Albania","country_code":"AL","capital":"Tirana","population":2886026,"flag_file_url":"https://restcountries.eu/data/alb.svg"},
```

##### Find country by name for example Finland
```bash
$ curl http://localhost:8080/countries/name/Finland
```

Response json

```json
[{"name":"Finland","country_code":"FI","capital":"Helsinki","population":5491817,"flag_file_url":"https://restcountries.eu/data/fin.svg"}]
```

#### Frontend
```bash
$ cd ../country-service-frontend
$ npm install
$ npm start
```

After 'npm start' country-service should be started automatically on your web browser in address http://localhost:3000

On frontend the main page shows list of all countries by default. The main page has navigation bar which have links to try find country go back to main page to show list of all countries.