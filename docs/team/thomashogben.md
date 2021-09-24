---
layout: page
title: John Doe's Project Portfolio Page
---

### Project: AddressBook Level 3

Trace2Gather is a desktop address book application used for managing hotel guests and rooms. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

## New Features:
1. Added the ability to check guests in and out of rooms.
    * What it does: allows the user to assign guests to a room and keep track of which rooms are occupied, as well as check them out when they leave the hotel.
    * Justification: This feature is indispensable for managing hotels.
    * Highlights: This enhancement affects existing commands and commands to be added in future. It required an in-depth analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.
    * Credits: 


2. Added a history command that allows the user to navigate to previous commands using up/down keys.

## Code contributed:
[RepoSense link]()
* **Testing for the following**:
  * CheckInCommand, CheckOutCommand
  * CheckInCommandParser, CheckOutCommandParser
  

* **Enhancements**:
    * Rewrote Vacancy class, greatly simplifying it and vanquishing bugs


* **Documentation**:
    * User Guide:
        * Added documentation for the features `checkin` and `checkout`

    * Developer Guide:
        * Added implementation details of the `checkin` and `checkout` feature.
  
