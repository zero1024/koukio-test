* PrioritiesTest is a test that I used for myself.
* MainTest is a test that is required by assignment. It either prints `EMPTY` or names of the 
students yet to be served. It's not a "real" test because it doesn't have any assertions.
* I assumed that `Priorities.getStudents()` should be like a pure function and shouldn't have state.
* It's not very clean that the first event in `getStudents(List<String> events)` will be the
total number of events. But this number is closely tied with the event list, and should be part of
  the method signature. 
  I decided not to change the method signature from the assignment.
  
