# Netflix Movie Search Engine (Maven Project)

## Description
This application is simple movie search engine for learning purposes.

## Technologies
- Java 
- Maven
- Picocli
- JUnit
- OpenCSV (for reading and writing csv files)

## Features
- Search movies by movie_name
- Search movie/movies by director
- Search movie/movies by release_year
- Add review to a movie
- Add a movie to csv file
- List all movies
- List all reviews
- List all movies with reviews


## How to run
- Clone the repository
- Install Maven and Java_jdk
- Run the following command in the terminal
```
mvn compile && mvn clean package
java -jar target/netflix-movie-search-engine-1.0-SNAPSHOT.jar
```

## JavaDoc
```
mvn site
It will generate the Javadoc for public members (defined in <reporting/>) using the given stylesheet (defined in <reporting/>), and with a help page (default value for nohelp is false).
`mvn javadoc:javadoc`
It will generate the Javadoc for private members (defined in <build/>) using the stylesheet (defined in <reporting/>), and with no help page (defined in <build/>).
```


### Contribution is welcomed
- Fork the repository
- Create a new branch
- Make changes
- Push changes
- Create a pull request



user stories with acceptance criteria.

