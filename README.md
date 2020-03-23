# Christian-and-Berkeley-s-algorithms

Simple Java implementation for Christian's and Berkeley's algorithms for clock synchronization.

Christian:
- The algorithm was implemented using RPC requests
- The server is the service provider (publisher)
- The client stores its current time and then sends a request to the server
- The server provides an interface with the funtion "getServerTime()"
- The function returns the server time as a string
- The string format was used to minimize the marshaling overhead
- Round trip time was imitated using System.sleep(millilseconds)
------------------------------------------------------------------------------------------------------------------
Berkeley:
- The master is assumed to be pre-selected
- Communication is using RPC
- Each slave provides an RPC interface
- Interface functions are: getSlaveMillis (getting the millis at the slave), setSlaveTime (for sending the synced time to the client)
- Each slave has specific port number which it uses to publish its RPC services interface
- The master creates a list of the slaves port numbers
- The master then gets the millis at each slave and calculates its difference to the millis at the master
- "System.currentMillis" was used intsead of "LocalDateTime.now()" because the later doesn't allow retreiving the milliseconds portion
- The average difference is the calculated with addition of a zero to the sum (masterTime - masterTime = 0)
- The master then calculates the new synced time by adding the avg differnce to its LocalDateTime.now()
- Finally, the master sends the new time to each of the slaves using their port numbers (from the list stated above) with the use of the function "setSlaveTime(String newTime)"
- ** The whole master code can be placed inside a loop so that it is repeated after a specific interval (interval: by placing "System.sleep(millis)" at the end of the iteration)
------------------------------------------------------------------------------------------------------------------

	---comments are included in the code to assist understanding---
