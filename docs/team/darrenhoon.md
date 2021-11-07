---
layout: page
title: Darren Hoon's Project Portfolio Page
---

# Project: Trace2Gather

Trace2Gather is a desktop address book application used for managing hotel guests and rooms. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

## New Feature(s)
  1. Linked Database's Room details to GUI, where Rooms are displayed on the GUI's list of rooms.
        * What it does: Allows users to visually see the rooms that were saved in the database and their last updated status.
        * Justification: This feature improves the product significantly because being able to visually check a room's status, such as its Occupancy Status, helps it's users to identify a room's status quickly and increases response time to the user requesting such information.
        * Highlights: This enhancement affects user interaction with the application. It required an in-depth analysis and understanding of the GUI codebase and jackSon's syntax, such as @FXML tags having only small characters
        * Credit: jackSon documentation, stackOverflow
  2. Find Room command to enable users to search for specific rooms
        * What it does: Allows users to search for specific rooms in the given list of rooms
        * Justification: This feature improves the product significantly as being able to quickly search for specific rooms helps the user to retrieve information about the room faster as compared to manually scrolling down till they find the room
        * Highlights: This enhancement required us to put ourselves in the shoes of a potential user and what were the pain points that might arise from our application without this feature.
        * Credit: Existing UML Diagrams, Well-thought out code structure that enables easy extensibility.
  3. GUI Updates (elaborated in below section on GUI)
        * What it does: Allow users to see in detail the changes to the state of the application based on their actions
        * Justification: Being able to visually see which guests are in which rooms or who stayed in the vicinity and their corresponding information fast enables faster retrieval of information
        * Highlights: These enhancements enabled us to visually check if our system is registering the changes based on the commands we type
        * Credit: Original AB3 team for making the code structure highly extensible

## Code Contributed
[RepoSense link](https://nus-cs2103-ay2122s1.github.io/tp-dashboard/?search=t13-3&sort=groupTitle&sortWithin=title&since=2021-09-17&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&tabAuthor=darrenhoon&tabRepo=AY2122S1-CS2103T-T13-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false)

#### Testing
* Room: TypicalRooms, RoomBuilder, RoomListTest
* Logic:
    * AddressBookParserTest: `FindRoomCommand`
    * FindRoomCommandParserTest
    * FindRoomCommandTest
* Model:
    * ResidencyTest


#### GUI
* Amended GUI to reflect addressBook.json values for Room
* Added styling to indicate vacancy status of rooms
* Included guests to rooms shown on GUI, along with appropriate styling
* Added History list in GUI along with its card styling

#### Misc
* Provided boilerplate code for team to start work in first week of team project
* Added Room, RoomNumber, Vacancy objects
* Bug fix where guests in rooms were not being updated on the successful call of an EditCommand


## Documentation
* User Guide:
  * Redirected Help Window's link to our project's User Guide page
* Developer Guide:
    * Amended UML Diagrams
* Use Cases:
    * Created Use Cases page along with respective use cases

## Community
* PRs reviewed (with non-trivial review comments): [\#144](https://github.com/nus-cs2103-AY2122S1/ip/pull/144), [\#486](https://github.com/nus-cs2103-AY2122S1/ip/pull/486), [\#173](https://github.com/nus-cs2103-AY2122S1/ip/pull/173)
* Contributed to forum discussions: [\#176](https://github.com/nus-cs2103-AY2122S1/forum/issues/176), [\#183](https://github.com/nus-cs2103-AY2122S1/forum/issues/183), [\#296](https://github.com/nus-cs2103-AY2122S1/forum/issues/296)
* Updated module setup guide for all students to reflect latest intelliJ settings: [\#3](https://github.com/se-edu/guides/pull/3)

## Additional
* Designed our icon using TraceTogether's logo as reference
