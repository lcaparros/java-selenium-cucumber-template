# java-selenium-cucumber-template

Skeleton of java project for Selenium tests based on Cucumber.

## Running test suite

To not depend on any local resource, such as browsers or webdrivers, this project include a dockerized way to run the test suite. To do it, juts start the selenium grid services:

```shell
docker compose -f selenium-grid.yml up -d
```

> :information_source: Feel free to modify **selenium-grid.yml** with the necessary services

Once started, the test suite will run pointing to your local selenium grid. The used browsers can be accessed to see what is being executed or for debugging purposes via VNC. For example, to access to the used Chrome browser just use a VNC viewer and point to **localhost:6900**
