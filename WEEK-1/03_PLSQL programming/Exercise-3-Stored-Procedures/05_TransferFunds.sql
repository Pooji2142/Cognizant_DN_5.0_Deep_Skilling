SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from IN NUMBER,
    p_to IN NUMBER,
    p_amount IN NUMBER
)
AS
    v_balance NUMBER;
BEGIN

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID=p_from;

    IF v_balance>=p_amount THEN

        UPDATE Accounts
        SET Balance=Balance-p_amount
        WHERE AccountID=p_from;

        UPDATE Accounts
        SET Balance=Balance+p_amount
        WHERE AccountID=p_to;

        DBMS_OUTPUT.PUT_LINE('Transfer Successful.');

        COMMIT;

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient Balance.');

    END IF;

END;
/



-- query to call the procedure
BEGIN
    TransferFunds(102,104,5000);
END;
/