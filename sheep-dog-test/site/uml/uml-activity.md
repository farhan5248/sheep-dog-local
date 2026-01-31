# UML Activity Patterns

These patterns correspond to asciidoc test case paths. Each test case follows one pattern.

Patterns are defined by discriminating partitions - partitions that uniquely identify a pattern.
A test case matches a pattern if it covers any of that pattern's discriminating partitions.

## Partitions

1. Step 14 -> Step 16
2. Step 1 -> Step 15
3. Step 4 -> Step 5
4. Step 4 -> Step 1
5. Step 1 -> Step 5
6. Step 12 -> Step 10
7. Step 1 -> Step 2, Step 2 -> Step 3
8. Step 14 -> Step 12
9. Step 4 -> Step 2
10. Step 4 -> Step 16
11. Step 16 -> Step 18
12. Step 1 -> Step 4
13. Step 15 -> Step 9
14. Step 16 -> Step 17
15. Step 5 -> Step 6
16. Step 1 -> Step 16
17. Step 1 -> Step 12
18. Step 10 -> Step 11
19. Step 1 -> Step 9, Step 9 -> Step 10
20. Step 7 -> Step 1
21. Step 15 -> Step 16
22. Step 10 -> Step 13, Step 13 -> Step 13
23. Step 5 -> Step 8
24. Step 4 -> Step 12

## Steps

1. The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
2. The xtext plugin generate step definition action is performed
3. The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file will be created as follows
4. The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
5. The xtext plugin list proposals action is performed as follows
6. The xtext plugin list proposals dialog will be set as follows
7. The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file background steps snippet is created as follows
8. The xtext plugin list proposals dialog will be empty
9. The xtext plugin validate dialog is empty
10. The xtext plugin list quickfixes action is performed as follows
11. The xtext plugin list quickfixes dialog will be empty
12. The xtext plugin validate dialog is set as follows
13. The xtext plugin list quickfixes dialog will be set as follows
14. The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file is created as follows
15. The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/app/Input file.asciidoc file is created as follows
16. The xtext plugin validate action is performed as follows
17. The xtext plugin validate dialog will be empty
18. The xtext plugin validate dialog will be set as follows

## Patterns

### Suggest

**Partitions**: 3, 5, 15, 20, 23

### Validate

**Partitions**: 1, 10, 11, 14, 16, 21

### Generate

**Partitions**: 7, 9

### Quickfix

**Partitions**: 8, 13, 18, 19
