SET SERVEROUTPUT ON;

BEGIN
    FOR cust IN (
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000
    )
    LOOP
        UPDATE Customers
        SET IsVIP='TRUE'
        WHERE CustomerID=cust.CustomerID;

        DBMS_OUTPUT.PUT_LINE(
            'Customer '
            || cust.CustomerID
            || ' promoted to VIP.'
        );
    END LOOP;

    COMMIT;
END;
/