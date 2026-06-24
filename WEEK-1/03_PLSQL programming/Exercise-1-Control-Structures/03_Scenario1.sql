SET SERVEROUTPUT ON;

BEGIN
    FOR cust IN (
        SELECT CustomerID
        FROM Customers
        WHERE Age > 60
    )
    LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = cust.CustomerID;

        DBMS_OUTPUT.PUT_LINE(
            'Discount applied to Customer ID: '
            || cust.CustomerID
        );
    END LOOP;

    COMMIT;
END;
/