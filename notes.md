We lay the groundwork for the api with recommended films “rotten potatoes ”. Start making a class review. This class contains an author's name, description and score. Then you make the class film. This class contains a list of reviews and all useful information that you can get from the csv file per movie.
Also provide a method for adding a review to the list for film.
Create a collection of films within your main, using an input stream you will go over your entire csv file to add each film to this collection.

Finally, you create a class where you can pass this collection. This class contains different methods for looking up films in different ways.

The following must be present.

Make sure you get a selection menu when starting the application. You must be able to do the following matters
Create review
Search movie by name or part of the name
List of films by a 'director'
List of films of a certain 'release_year'
Make sure you have the necessary Classes and other objects to save all of the above
The necessary error checks when you add a review or look up a movie.
You can safely add other functions, the above is the minimum that runs in your main.

## Process & project flow
```
1.  Formulate at least three user stories for your programming project.  They must have the form practiced during class.

2.  For each user story, formulate at least three acceptance criteria in the Gherkin format.

3.  When evaluating your programming project, it will be checked whether the entire functionality of your app is covered by the user stories, and the acceptance criteria will check whether your app reaches the requested quality level.
```

## User stories
1- As a user, I want to be able to add a review to a movie so that I can share my opinion with others.
2- As a user, I want to be able to search for a movie by name or part of the name so that I can find the movie I am looking for.
3- As a user, I want to be able to list movies by a director so that I can see all the movies made by that director.


## Risk analysis
### Identify 5 project risks (process risk)
- The csv file is not read correctly
- Software crashes
- Validation of the input
- Software is not user-friendly
- The software is not tested properly
- Software may not be able to handle large amounts of data in the csv file

### Product risks of your user stories (product risk)
- The user does not understand the menu
- The user does not understand the search function
- Software does not return the correct results
- SOftware crash when adding a review
- SOftware crash when give a wrong input


## Acceptance criteria
### User story 1
```
Feature: Add a review to a movie
    As a user, I want to be able to add a review to a movie so that I can share my opinion with others.
    
    Scenario: Add a review to a movie
        Given I have a movie
        When I add a review to the movie
        Then the review is added to the movie
```
### User story 2
```
Feature: Search for a movie by name or part of the name
    as a user, I want to able to search a movie by full name or part of the movie_name so that i can find the movie i am searching for.

    Scenario: Search for a movie by name
        Given I have a movie
        When I search for the movie by name
        Then the movie is found
```

### User story 3
```
Feature: List movies by a director
    As a user, I want to be able to list movies by a director so that I can see all the movies made by that director.

    Scenario: List movies by a director
        Given I have a director
        When I list movies by the director
        Then all the movies made by that director are listed
```

### User story 4
```
Feature: Add a new movie into csv file 
    As a user i want to able to add a new movie into the csv file so that i can add new movies to the collection.

    Scenario: Add a new movie into csv file
        Given I have a new movie
        When I add the new movie into the csv file
        Then the new movie is added into the csv file
```
