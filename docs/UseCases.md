---
layout: page
title: Use Cases
---

This page contains the use cases in our project. The sections below have been segmented to major sections where each
use case is classified under to allow for easier navigation.
<br><br>
For all use cases below, the **System** is the `Trace2Gather` and the **Actor** is the `user`, unless specified otherwise.


* Table of Contents 
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Guest

### Use case: Delete a guest
**MSS**
1.  User requests to list guests
2.  Trace2Gather shows a list of guests
3.  User requests to delete a specific guest in the list
4.  Trace2Gather deletes the guest
    Use case ends.

**Extensions**
* 2a. The list is empty.
  Use case ends.
* 3a. The given index is invalid.
    * 3a1. Trace2Gather shows an error message.
      Use case resumes at step 2.

<br><br>

### Use case: Add a guest
**MSS**

1.  User requests to add a person and inputs the necessary parameters
2.  Trace2Gather adds the person with the input details
3.  Trace2Gather displays a message to the user indicating that the person has been added

    Use case ends.

**Extensions**

* 1a. There are missing parameters or input is not in the correct format
    * 1a1. Trace2Gather displays a message indicating to the user the required parameters
    * 1a2. User inputs the parameters again until all required parameters are input. 
      Use case resumes at step 2.

<br><br>

### Use case: Edit a guest
**MSS**
1.  User requests to list guests
2.  Trace2Gather shows a list of guests
3.  User requests to edit a guest at a specific index in the list
4.  Trace2Gather edits the guest
    Use case ends.

**Extensions**
* 2a. The list is empty. 
  <br>Use case ends.
* 2b. The given index is invalid.
    * 2b1. Trace2Gather displays a message indicating to the user the required format.
    * 2b2. User edits the index to the correct index.
      Use case resumes at step 3.
* 2c. The input command is not in the correct format.
    * 2c1. Trace2Gather displays a message indicating to the user the required format.
    * 2c2. User edits the input to the correct format.
      Use case resumes at step 3.

<br><br>

### Use case: Retrieve all guests
**MSS**

1.  User requests to retrieve all the entries of guests
2.  User is able to view all the entries of guests
    Use case ends.

### Use case: Search for guest(s) by name
**MSS**

1.  User requests to find a specific guest using the name of the guest
2.  User is able to view all guests with the same name
    Use case ends.

**Extensions**
* 1a. The list containing guests with the same name is empty.
  Use case ends.

<br><br>


--------------------------------------------------------------------------------------------------------------------


--------------------------------------------------------------------------------------------------------------------


--------------------------------------------------------------------------------------------------------------------

## Use case: retrieve occupied/vacant rooms
**MSS**
1.  User requests to retrieve all Rooms that are either occupied or vacant
2.  User is able to view all the entries of Rooms that are either occupied or vacant
    Use case ends.

--------------------------------------------------------------------------------------------------------------------

## Use case: retrieve occupied/vacant rooms
**MSS**
1.  User requests to retrieve all Rooms that are either occupied or vacant
2.  User is able to view all the entries of Rooms that are either occupied or vacant
    Use case ends.

--------------------------------------------------------------------------------------------------------------------

