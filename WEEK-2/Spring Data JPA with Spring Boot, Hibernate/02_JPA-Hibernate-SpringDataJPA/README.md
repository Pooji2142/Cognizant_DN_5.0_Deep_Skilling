# Difference Between JPA, Hibernate and Spring Data JPA

## Objective

To understand the differences between JPA, Hibernate, and Spring Data JPA, and how they work together in Java applications for database persistence.

---

## What is JPA?

**JPA (Java Persistence API)** is a Java specification (JSR 338) that defines a standard way to map Java objects to relational database tables.

### Features

- JPA is a specification, not a framework.
- Defines rules for Object Relational Mapping (ORM).
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

## Relationship

```text
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

## Comparison Table

| Feature | JPA | Hibernate | Spring Data JPA |
|---------|-----|-----------|-----------------|
| Type | Specification | ORM Framework | Spring Module |
| Implementation | No | Yes | No |
| Database Operations | No | Yes | Uses Hibernate |
| SQL Generation | No | Yes | Through Hibernate |
| CRUD Operations | No | Yes | Yes |
| Boilerplate Code | High | Medium | Very Low |
| Transaction Management | No | Manual | Automatic using `@Transactional` |

---

## Hibernate Example

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

        if (tx != null)
            tx.rollback();

        e.printStackTrace();

    } finally {

        session.close();

    }

    return employeeID;

}
```

### Explanation

- Open a Hibernate Session.
- Begin a transaction.
- Save the Employee object.
- Commit the transaction.
- Roll back if an exception occurs.
- Close the Session.

This approach requires a lot of manual coding.

---

## Spring Data JPA Example

### EmployeeRepository.java

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
```

### EmployeeService.java

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void addEmployee(Employee employee) {

        employeeRepository.save(employee);

    }
}
```

### Explanation

Spring Data JPA automatically:

- Opens the session.
- Begins the transaction.
- Saves the entity.
- Commits the transaction.
- Closes the session.

The developer only writes:

```java
employeeRepository.save(employee);
```

---

## Advantages of JPA

- Standard Java specification.
- Database independent.
- Portable across different ORM providers.
- Defines standard persistence APIs.

---

## Advantages of Hibernate

- Implements JPA.
- Automatically generates SQL.
- Reduces JDBC code.
- Supports caching.
- Supports lazy loading.
- Provides powerful ORM features.

---

## Advantages of Spring Data JPA

- Reduces boilerplate code.
- Provides built-in CRUD methods.
- Supports automatic query generation.
- Easy transaction management using `@Transactional`.
- Easy integration with Spring Boot.
- Improves developer productivity.

---

## Conclusion

- **JPA** is a specification that defines how Java objects are mapped to database tables.
- **Hibernate** is an ORM framework that implements the JPA specification and performs the actual database operations.
- **Spring Data JPA** is a Spring module that simplifies the use of Hibernate by reducing boilerplate code and providing repository interfaces such as `JpaRepository`.

---

## Summary

| Technology | Purpose |
|------------|---------|
| JPA | Specification for Object Relational Mapping (ORM) |
| Hibernate | ORM framework implementing JPA |
| Spring Data JPA | Simplifies JPA and Hibernate with repositories and automatic CRUD operations |

---

## References

1. https://dzone.com/articles/what-is-the-difference-between-hibernate-and-sprin-1
2. https://www.javaworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html
