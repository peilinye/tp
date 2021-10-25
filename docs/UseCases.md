---
layout: page
title: Use Cases
---

* Table of Contents
  {:toc}


--------------------------------------------------------------------------------------------------------------------
## Introduction
This page contains the use cases in our project. For all use cases below, the **System** is the `Trace2Gather` and the **Actor** is the `user`, unless specified otherwise.

--------------------------------------------------------------------------------------------------------------------

## Use case: Deleting a guest
**MSS**

1.  User requests to list persons
2.  Trace2Gather shows a list of persons
3.  User requests to delete a specific person in the list
4.  Trace2Gather deletes the person

    Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.

* 3a. The given index is invalid.

    * 3a1. Trace2Gather shows an error message.

      Use case resumes at step 2.

--------------------------------------------------------------------------------------------------------------------

## Use case: Adding a person
**MSS**

1.  User requests to add a person and inputs the necessary parameters
2.  Trace2Gather adds the person with the input details
3.  Trace2Gather displays a message to the user indicating that the person has been added

    Use case ends.

**Extensions**

* 1a. There are missing parameters or input is not in the correct format
* 1b. Trace2Gather displays a message indicating to the user the required parameters
* 1c. User inputs the parameters again until all required parameters are input. Use case resumes at step 2.

--------------------------------------------------------------------------------------------------------------------

## Use case: retrieve all entries
**MSS**

1.  User requests to retrieve all the entries of either Room, Guests, or History
2.  User is able to view all the entries of Room, Guests, or History
    Use case ends.

--------------------------------------------------------------------------------------------------------------------

## Use case: retrieve occupied/vacant rooms
**MSS**

1.  User requests to retrieve all Rooms that are either occupied or vacant
2.  User is able to view all the entries of Rooms that are either occupied or vacant
    Use case ends.

--------------------------------------------------------------------------------------------------------------------
