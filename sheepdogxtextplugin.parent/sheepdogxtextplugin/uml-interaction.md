# UML Interaction Patterns

## Logging

Define how **Xtext** uses **Log4J**, don't duplicate anything already in tech-log4j.md.

Also explain how **Log4J** works with **SLF4J** in the jar file
Right now I don't see errors being logged to the console in the current implementation.
There aren't any compile or runtime errors either so some configuration is probably missing.
Once I've figured that out, I'll put an example here of how that's supposed to work.

## Exceptions

Give rules for when exceptions from the jar are handled vs thrown for the user to act.