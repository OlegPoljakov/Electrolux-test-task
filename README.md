# Electrolux-test-task

Simple api service with database. Java + Some JPA, some Spring Framework and H2 database.

Here we have an entities of stove and dishes washing machine. Both can be created, turned on and off and the temperature can be set. All the changes are saved in database.

Here the requests to test:

http://localhost:8889/dishwasher/new?model=margo (where "margo" is model and can be any name);
 
http://localhost:8889/dishwasher/on?id=1 (Turns ON the item with id = 1. If there are no item with id = 1, the 404 error arises);

http://localhost:8889/dishwasher/off?id=1 (Turns OFF the item with id = 1 and Set temp to 0. If there are no item with id = 1, the 404 error arises);

http://localhost:8889/dishwasher/temp?id=1&temp=40 (sets the temp to 40 at the item with id = 1. If there are no item with id = 1, the 404 error arises);


Same thing with the stove:

http://localhost:8889/stove/new?model=one
 
http://localhost:8889/stove/on?id=1

http://localhost:8889/stove/off?id=1

http://localhost:8889/stove/temp?id=1&temp=40


I also tried to write some junit tests of controller methods, but haven't succeded yet.

Here some of the shortcomings that has to be eliminated:
- No exception handling and appropriate HTTP response codes
- Business logic contains only simple CRUD operations
- Two supported appliances have completely the same implementation in terms of code
- Only controller is partially covered by tests
