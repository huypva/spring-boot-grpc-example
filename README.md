The example project for StringBoot service

<div align="center">
    <img src="./assets/images/spring_boot_icon.png"/>
</div>

## Getting Started

## Project structure
```
.
├── spring-boot-grpc-client
│   ├── Dockerfile
│   ...
├── spring-boot-grpc-server
│   ├── Dockerfile
│   ...
├── docker-compose.yaml
|
└── README.md
```

## Prerequisites
- Make sure that you have Docker and Docker Compose installed
  - Windows or macOS:
    [Install Docker Desktop](https://www.docker.com/get-started)
  - Linux: [Install Docker](https://www.docker.com/get-started) and then
    [Docker Compose](https://github.com/docker/compose)

## Start project
### Start project in local

- Build project
```shell script
$ ./mvnw clean package
```

- Start server side
```shell script
$ cd spring-boot-grpc-server
$ ../mvnw spring-boot:run
...
```

- Start client side
```shell script
$ cd spring-boot-grpc-client
$ ./mvnw spring-boot:run
...
```

### Start project in docker 

- Start project
```shell script
$ docker-compose up -d
```

- Stop project
```shell script
$ docker-compose down
```

## Run testing

```shell script
curl -X GET http://localhost:8081/hello?name=World
```

## Contribute

## Reference