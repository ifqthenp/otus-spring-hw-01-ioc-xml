# Otus Spring Framework Developer

- Student: Andrei Bogomja
- Course: Jun-2018

## Homework 1. Configuring Spring IoC container with XML

**Quiz for students**

Write a program for students testing.

Create `csv` file in `resources` folder with 5 questions and options for answers.
The program should ask for user name, output the questions in the console, and 
calculate the resulting score.

Each service must solve a specific task. Dependencies must be configured in IoC
container.

Optional: cover services with tests

## How to get the project running

Clone repository from GitHub:

```shell
git clone git@github.com:ifqthenp/otus-spring-hw-01-ioc-xml.git
```

Change into the folder with:

```shell
cd otus-spring-hw-01-ioc-xml
```

Make `gradlew` script executable (or use `gradlew.bat` if running on Windows):

```shell
chmod +x gradlew 
```

Build executable `jar`:

```shell
./gradlew clean fatJar
```

Run the program:

```shell
java -jar build/libs/otus-spring-hw-01-fatjar.jar
```
