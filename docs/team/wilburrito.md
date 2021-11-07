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
3. Edited logic for prevention of duplicate person objects
   * Change the way duplications are handled. Instead of being handled by comparing the names of Person objects, Trace2Gather now does it by using its Nric field.
   * This allows for Person objects to have the same name, which is more realistic as compared to disallowing duplicate names.

* **Code contributed**:
  [RepoSense link](https://nus-cs2103-ay2122s1.github.io/tp-dashboard/?search=wilburrito&sort=groupTitle&sortWithin=title&since=2021-09-17&timeframe=commit&mergegroup=&groupSelect=groupByAuthors&breakdown=false&tabOpen=true&tabAuthor=wilburrito&tabRepo=AY2122S1-CS2103T-T13-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&tabType=authorship)

* **Documentation**:
    * User Guide:
        * Adapted user guide to suit our project.
        * Fixed example usage of code, changed the tone of language used to be more engaging.
        * Fixed most of the UG bugs from the PE-D.
    * Developer Guide:
        * Adapted UML diagrams to suit our project.
        * Adapted developer guide to suit our project.
        * Fixed any DG bugs that may have come up from changing the implementation of the AB3 code to suit Trace2Gather.
    * Miscellaneous
        * Adapted documentation to remove traces of AB3.
