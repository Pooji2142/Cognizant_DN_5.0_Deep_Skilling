SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType='Savings';

    DBMS_OUTPUT.PUT_LINE('Monthly interest applied.');

    COMMIT;
END;
/


-- this block is used to call the procedure
BEGIN
    ProcessMonthlyInterest;
END;
/
