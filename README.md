# Aid Platform
This is a hands-on project where I intend to learn more about Quarkus and its ecosystem by building different microservices and serverless APIs.

## Services
- [service_boilerplate](https://github.com/Tavet/AidPlatform/tree/main/services/service_boilerplate)
    This is a boilerplate for a microservice in Quarkus applying Ports & Adapters architecture (aka Hexagonal Architecture)

## Infrastructure
- Remove docker containers ```docker rm -f $(docker ps -a -q)```
- Create docker containers ```docker-compose up -d```

- [Flyway Naming Patterns](https://www.red-gate.com/blog/database-devops/flyway-naming-patterns-matter)