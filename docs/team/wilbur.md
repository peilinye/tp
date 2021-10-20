---
layout: page
title: Wilbur's Project Portfolio Page
---

### Project: Trace2Gather

Trace2Gather is a desktop address book application used for managing hotel guests and rooms. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

## New Feature(s)
1. Added the ability to search for guests by name.
    * Mirrors the logic from AB3 to search for Persons, with a different keyword.
    * Credit: Original AB3 team.
2. Change the identification logic for Person objects.
   * Persons were initially identified by an `Id` field, which was regenerated every time Trace2Gather is opened.
   * Changed the `Id` field to an `Nric` field instead, which guarantees uniqueness and may eliminate bugs.
   * Edited the storage such that the `Nric` of a person is stored in 
* Edited logic for prevention of duplicate person objects

* **Code contributed**:
  [RepoSense link]()

* **Documentation**:
    * User Guide:
        * Adapted user guide to suit our project.
    * Developer Guide:
        * Adapted UML diagrams to suit our project.
        * Adapted developer guide to suit our project.
    * Miscellaneous
        * Adapted documentation to remove traces of AB3.
