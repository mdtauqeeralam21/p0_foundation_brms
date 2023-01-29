show databases;
use p0_brms;
select*from bus;
alter table seat_status drop index  seatNo;
create index seatNo on seat_status(Seat_No);
select*from seat_status;