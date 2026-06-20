create table customers (
   customerid   number primary key,
   name         varchar2(100),
   dob          date,
   balance      number,
   isvip        varchar2(5),
   lastmodified date
);


create table accounts (
   accountid    number primary key,
   customerid   number,
   accounttype  varchar2(20),
   balance      number,
   lastmodified date,
   foreign key ( customerid )
      references customers ( customerid )
);


create table transactions (
   transactionid   number primary key,
   accountid       number,
   transactiondate date,
   amount          number,
   transactiontype varchar2(10),
   foreign key ( accountid )
      references accounts ( accountid )
);


create table loans (
   loanid       number primary key,
   customerid   number,
   loanamount   number,
   interestrate number,
   startdate    date,
   enddate      date,
   foreign key ( customerid )
      references customers ( customerid )
);


create table employees (
   employeeid number primary key,
   name       varchar2(100),
   position   varchar2(50),
   salary     number,
   department varchar2(50),
   hiredate   date
);


insert into customers values ( 1,
                               'John Doe',
                               to_date('1955-05-15','YYYY-MM-DD'),
                               12000,
                               'FALSE',
                               sysdate );


insert into customers values ( 2,
                               'Jane Smith',
                               to_date('1995-07-20','YYYY-MM-DD'),
                               5000,
                               'FALSE',
                               sysdate );


insert into accounts values ( 1,
                              1,
                              'Savings',
                              10000,
                              sysdate );


insert into accounts values ( 2,
                              2,
                              'Checking',
                              5000,
                              sysdate );


insert into loans values ( 1,
                           1,
                           5000,
                           5,
                           sysdate,
                           sysdate + 20 );


insert into employees values ( 1,
                               'Alice',
                               'Manager',
                               70000,
                               'HR',
                               sysdate );


insert into employees values ( 2,
                               'Bob',
                               'Developer',
                               60000,
                               'IT',
                               sysdate );


commit;



begin
   for c in (
      select customerid
        from customers
       where months_between(
         sysdate,
         dob
      ) / 12 > 60
   ) loop
      update loans
         set
         interestrate = interestrate - 1
       where customerid = c.customerid;


   end loop;


   commit;
end;
/

select *
  from loans;

begin
   for c in (
      select customerid
        from customers
   ) loop
      update customers
         set
         isvip = 'TRUE'
       where customerid = c.customerid
         and balance > 10000;


   end loop;


   commit;
end;
/

select *
  from customers;

   SET SERVEROUTPUT ON;

begin
   for l in (
      select c.name,
             l.enddate
        from customers c
        join loans l
      on c.customerid = l.customerid
       where l.enddate between sysdate and sysdate + 30
   ) loop
      dbms_output.put_line('Reminder: Loan of '
                           || l.name
                           || ' is due on ' || l.enddate);
   end loop;
end;
/


create or replace procedure processmonthlyinterest is
begin
   update accounts
      set
      balance = balance + ( balance * 0.01 )
    where accounttype = 'Savings';



   commit;
end;
/

EXEC ProcessMonthlyInterest;

select *
  from accounts;

create or replace procedure updateemployeebonus (
   dept_name in varchar2,
   bonus     in number
) is
begin
   update employees
      set
      salary = salary + ( salary * bonus / 100 )
    where department = dept_name;



   commit;
end;
/

EXEC UpdateEmployeeBonus('IT',10);

select *
  from employees;

create or replace procedure transferfunds (
   from_acc in number,
   to_acc   in number,
   amount   in number
) is
   bal number;
begin
   select balance
     into bal
     from accounts
    where accountid = from_acc;



   if bal >= amount then
      update accounts
         set
         balance = balance - amount
       where accountid = from_acc;



      update accounts
         set
         balance = balance + amount
       where accountid = to_acc;



      commit;
      dbms_output.put_line('Transfer Successful');
   else
      dbms_output.put_line('Insufficient Balance');
   end if;


end;
/

   SET SERVEROUTPUT ON;

EXEC TransferFunds(1,2,1000);

select *
  from accounts;