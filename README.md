# Project Hibernate: MovieRental Hub - Results, Analysis, and Optimization

## Completed Tasks

### 1. Database Loading and Deployment

- Loaded the dump file and deployed it on the local machine.
- Utilized the test database included in the MySQL installation package.

### 2. Maven Project Creation

- Created a new Maven project and added the necessary dependencies:
  - `hibernate-core-jakarta`
  - `mysql-connector-java`
  - `p6spy`

### 3. Entity Classes Creation

- Developed entity classes for all tables in the movie schema and configured mapping using Hibernate.

### 4. Method Implementations

#### Method for Creating a New Customer

- Added a method to create a new customer with all related fields.
- Ensured transactionality to avoid incorrect states in the database.

#### Method for Returning Rented Film

- Implemented a transactional method describing the event of "customer returning a previously rented film."
- Selected a customer and film at own discretion.

#### Method for Renting a Film and Payment

- Added a transactional method describing the event "customer renting inventory and making a payment."
- Ensured the film is available for rent.

#### Method for Releasing a New Film

- Implemented a transactional method describing the event "release of a new film and its availability for rent."
- Selected film, language, actors, categories, etc., at own discretion.

## Database Analysis

During the project, an analysis of the database structure was conducted.

### Table Analysis

#### Table `film`

- **Recommendations:**
  - Consider creating a separate table for the `special_features` columns, which holds relationships between films and their features.

#### Table `film_text`

- **Analysis:**
  - Appears redundant, as its data mainly duplicates information from the `film` table.
- **Recommendations:**
  - Consider removing this table and using `film` for textual data.

#### Table `inventory`

- **Recommendations:**
  - Adding additional information about status (e.g., "available" or "rented") could be useful.
  - In that case, create an additional table for statuses and establish a relationship with `inventory`.

#### Table `customer`

- **Recommendations:**
  - For additional normalization, consider creating a separate table for customer addresses to avoid address duplication.

### Conclusion

While working on the project, opportunities for optimization and normalization of the database structure were identified. The recommendations were taken into account and implemented for further improvement of code efficiency and readability.
