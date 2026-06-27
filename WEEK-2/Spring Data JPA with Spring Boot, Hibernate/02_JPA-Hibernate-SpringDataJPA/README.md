# Difference Between JPA, Hibernate and Spring Data JPA

## Objective

To understand the differences between JPA, Hibernate, and Spring Data JPA, and how they work together in Java applications for database persistence.

---

## What is JPA?

**JPA (Java Persistence API)** is a Java specification (JSR 338) that defines a standard way to map Java objects to relational database tables.

### Features

- JPA is a specification, not a framework.
- Defines rules for object-relational mapping (ORM).
- Does not provide any implementation.
- Uses annotations such as:
  - `@Entity`
  - `@Table`
  - `@Id`
  - `@Column`
- Hibernate is one of the implementations of JPA.

---

## What is Hibernate?

**Hibernate** is an Object Relational Mapping (ORM) framework that implements the JPA specification.

### Features

- Implements JPA.
- Maps Java objects to database tables.
- Automatically generates SQL queries.
- Handles CRUD operations.
- Supports caching and lazy loading.
- Reduces JDBC boilerplate code.

---

## What is Spring Data JPA?

**Spring Data JPA** is a Spring Framework module that simplifies working with JPA implementations such as Hibernate.

### Features

- Does not implement JPA.
- Uses Hibernate (or another JPA provider) internally.
- Reduces boilerplate code.
- Provides built-in CRUD operations.
- Supports automatic query generation.
- Manages transactions using `@Transactional`.

---

# Relationship

```
Application
      │
      ▼
Spring Data JPA
      │
      ▼
Hibernate
      │
      ▼
JPA Specification
      │
      ▼
Database
```

---

# Comparison Table

| Feature                | JPA           | Hibernate     | Spring Data JPA                  |
| ---------------------- | ------------- | ------------- | -------------------------------- |
| Type                   | Specification | ORM Framework | Spring Module                    |
| Implementation         | No            | Yes           | No                               |
| Database Operations    | No            | Yes           | Uses Hibernate                   |
| SQL Generation         | No            | Yes           | Through Hibernate                |
| CRUD Operations        | No            | Yes           | Yes                              |
| Boilerplate Code       | High          | Medium        | Very Low                         |
| Transaction Management | No            | Manual        | Automatic using `@Transactional` |

---

# Hibernate Example

```java
/* Method to CREATE an employee in the database */

public Integer addEmployee(Employee employee){

    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;

    try {

        tx = session.beginTransaction();

        employeeID = (Integer) session.save(employee);

        tx.commit();

    } catch (HibernateException e) {

        if(tx != null)
            tx.rollback();

        e.printStackTrace();

    } finally {

        session.close();

    }

    return employeeID;

}
```

### Explanation

- Open a Hibernate session.
- Begin a transaction.
- Save the object.
- Commit the transaction.
- Roll back if an exception occurs.
- Close the session.

This requires a lot of manual coding.

---

# Spring Data JPA Example

### Repository

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
```

### Service

```java
@Autowired
private EmployeeRepository employeeRepository;

@Transactional
public void addEmployee(Employee employee){

    employeeRepository.save(employee);

}
```

### Explanation

Spring Data JPA automatically:

- Opens the session
- Begins the transaction
- Saves the entity
- Commits the transaction
- Closes the session

The developer only writes one line:

```java
employeeRepository.save(employee);
```

---

# Advantages of JPA

- Standard specification
- Database independent
- Portable across different ORM providers

---

# Advantages of Hibernate

- Easy object-relational mapping
- Automatic SQL generation
- Reduces JDBC code
- Supports caching
- Supports lazy loading

---

# Advantages of Spring Data JPA

- Minimal boilerplate code
- Easy CRUD operations
- Built-in repository support
- Automatic query generation
- Transaction management
- Easy integration with Spring Boot

---

# Conclusion

- **JPA** defines the rules for persistence.
- **Hibernate** implements those rules and performs database operations.
- **Spring Data JPA** simplifies the use of Hibernate by reducing boilerplate code and providing repository interfaces.

---

# Summary

| Technology      | Purpose                                                                      |
| --------------- | ---------------------------------------------------------------------------- |
| JPA             | Specification for object-relational mapping                                  |
| Hibernate       | ORM framework implementing JPA                                               |
| Spring Data JPA | Simplifies JPA and Hibernate with repositories and automatic CRUD operations |

---

## References

- https://dzone.com/articles/what-is-the-difference-between-hibernate-and-sprin-1
- https://www.javaworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html# Difference Between JPA, Hibernate and Spring Data JPA

## Objective

To understand the differences between JPA, Hibernate, and Spring Data JPA, and how they work together in Java applications for database persistence.

---

## What is JPA?

**JPA (Java Persistence API)** is a Java specification (JSR 338) that defines a standard way to map Java objects to relational database tables.

### Features

- JPA is a specification, not a framework.
- Defines rules for object-relational mapping (ORM).
- Does not provide any implementation.
- Uses annotations such as:
  - `@Entity`
  - `@Table`
  - `@Id`
  - `@Column`
- Hibernate is one of the implementations of JPA.

---

## What is Hibernate?

**Hibernate** is an Object Relational Mapping (ORM) framework that implements the JPA specification.

### Features

- Implements JPA.
- Maps Java objects to database tables.
- Automatically generates SQL queries.
- Handles CRUD operations.
- Supports caching and lazy loading.
- Reduces JDBC boilerplate code.

---

## What is Spring Data JPA?

**Spring Data JPA** is a Spring Framework module that simplifies working with JPA implementations such as Hibernate.

### Features

- Does not implement JPA.
- Uses Hibernate (or another JPA provider) internally.
- Reduces boilerplate code.
- Provides built-in CRUD operations.
- Supports automatic query generation.
- Manages transactions using `@Transactional`.

---

# Relationship

```
Application
      │
      ▼
Spring Data JPA
      │
      ▼
Hibernate
      │
      ▼
JPA Specification
      │
      ▼
Database
```

---

# Comparison Table

| Feature                | JPA           | Hibernate     | Spring Data JPA                  |
| ---------------------- | ------------- | ------------- | -------------------------------- |
| Type                   | Specification | ORM Framework | Spring Module                    |
| Implementation         | No            | Yes           | No                               |
| Database Operations    | No            | Yes           | Uses Hibernate                   |
| SQL Generation         | No            | Yes           | Through Hibernate                |
| CRUD Operations        | No            | Yes           | Yes                              |
| Boilerplate Code       | High          | Medium        | Very Low                         |
| Transaction Management | No            | Manual        | Automatic using `@Transactional` |

---

# Hibernate Example

```java
/* Method to CREATE an employee in the database */

public Integer addEmployee(Employee employee){

    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;

    try {

        tx = session.beginTransaction();

        employeeID = (Integer) session.save(employee);

        tx.commit();

    } catch (HibernateException e) {

        if(tx != null)
            tx.rollback();

        e.printStackTrace();

    } finally {

        session.close();

    }

    return employeeID;

}
```

### Explanation

- Open a Hibernate session.
- Begin a transaction.
- Save the object.
- Commit the transaction.
- Roll back if an exception occurs.
- Close the session.

This requires a lot of manual coding.

---

# Spring Data JPA Example

### Repository

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
```

### Service

```java
@Autowired
private EmployeeRepository employeeRepository;

@Transactional
public void addEmployee(Employee employee){

    employeeRepository.save(employee);

}
```

### Explanation

Spring Data JPA automatically:

- Opens the session
- Begins the transaction
- Saves the entity
- Commits the transaction
- Closes the session

The developer only writes one line:

```java
employeeRepository.save(employee);
```

---

# Advantages of JPA

- Standard specification
- Database independent
- Portable across different ORM providers

---

# Advantages of Hibernate

- Easy object-relational mapping
- Automatic SQL generation
- Reduces JDBC code
- Supports caching
- Supports lazy loading

---

# Advantages of Spring Data JPA

- Minimal boilerplate code
- Easy CRUD operations
- Built-in repository support
- Automatic query generation
- Transaction management
- Easy integration with Spring Boot

---

# Conclusion

- **JPA** defines the rules for persistence.
- **Hibernate** implements those rules and performs database operations.
- **Spring Data JPA** simplifies the use of Hibernate by reducing boilerplate code and providing repository interfaces.

---

# Summary

| Technology      | Purpose                                                                      |
| --------------- | ---------------------------------------------------------------------------- |
| JPA             | Specification for object-relational mapping                                  |
| Hibernate       | ORM framework implementing JPA                                               |
| Spring Data JPA | Simplifies JPA and Hibernate with repositories and automatic CRUD operations |

---

## References

- https://dzone.com/articles/what-is-the-difference-between-hibernate-and-sprin-1
- https://www.javaworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html
