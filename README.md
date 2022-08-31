## evaluation-tool

### Short about the project
Simple implementation of evaluation tool without saving data to DB.

### Technologies used
- Spring Boot 2.7.3
- Java 11

### How to run
1. Clone
2. Run

### To test solution
Please send POST request, with **Content-Type text/plain** on this endpoint:
```
http://localhost:8080/tool/evaluate
```
body example:
```
7
C 1.1 8.15.1 P 15.10.2012 83
C 1 10.1 P 01.12.2012 65
C 1.1 5.5.1 P 01.11.2012 117
D 1.1 8 P 01.01.2012-01.12.2012
C 3 10.2 N 02.10.2012 100
D 1 * P 8.10.2012-20.11.2012
D 3 10 P 01.12.2012
```
output should be:
```
83
100
-
```
