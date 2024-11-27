ASD Lab 8 - DOP Ticket Example
G00384389 / Mark Hughes

Benefits of Immutability:
Immutability gurantees thread safety as objects can be shared across multiple threads without synchronization, eliminating common concurrency 
issues like race conditions. Immutability also make it easier to maintain system variants and rules, like setting that the concert date 
is always in the future or that ticket prices are cannot be negatively priced.


Drawbacks of Immutability include increased performance overheads. Having to create a new object each time data is modified is less 
efficient in terms of memory and processing compared to mutating existing object, this usually also leads to higher memory consumption.
Updating nested/complex structures requires ripping apart the entire hierarchy, which can make code harder to maintain.


