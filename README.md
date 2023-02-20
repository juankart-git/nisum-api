
# Nisum API - Juan Carlos Acosta

## Content

 - [Requirements](#requerimientos)
 - [Used Technologies](#used-technologies)
 - [Coments](#comments)
- [Setup](#setup)
    - [Instructions](#intructions)
    - [Usage](#usage)
    - [API URL](#api)
    - [Services](#services)
        - [Swagger](#swagger)
- [Test](#test)
    - [UnitTest](#unittest)
    - [Coverage](#cobertura)

## Requirements

### Evaluación: JAVA

Desarrolle una aplicación que exponga una API RESTful de creación de usuarios.
Todos los endpoints deben aceptar y retornar solamente JSON, inclusive al para los mensajes de
error.
Todos los mensajes deben seguir el formato:
```
{
    "mensaje": "mensaje de error"
}
```
#### Registro

● Ese endpoint deberá recibir un usuario con los campos "nombre", "correo", "contraseña",
más un listado de objetos "teléfono", respetando el siguiente formato:

```
{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}
```
● Responder el código de status HTTP adecuado

● En caso de éxito, retorne el usuario y los siguientes campos:

 - id: id del usuario (puede ser lo que se genera por el banco de datos, pero sería
más deseable un UUID)
 - created: fecha de creación del usuario
 - modified: fecha de la última actualización de usuario
 - last_login: del último ingreso (en caso de nuevo usuario, va a coincidir con la
fecha de creación)
 - token: token de acceso de la API (puede ser UUID o JWT)
 - isactive: Indica si el usuario sigue habilitado dentro del sistema.

● Si caso el correo conste en la base de datos, deberá retornar un error "El correo ya
registrado".

● El correo debe seguir una expresión regular para validar que formato sea el correcto.
(aaaaaaa@dominio.cl)

● La clave debe seguir una expresión regular para validar que formato sea el correcto. (El
valor de la expresión regular debe ser configurable)

● El token deberá ser persistido junto con el usuario

#### Requisitos
● Plazo: 2 días, si tienes algún inconveniente con el tiempo comunicate con nosotros

● Banco de datos en memoria. Ejemplo: HSQLDB o H2.

● Proceso de build vía Gradle o Maven.

● Persistencia con JPA. Ejemplo: EclipseLink, Hibernate u OpenJPA.

● Framework SpringBoot.

● Java 8+

● Entrega en un repositorio público (github o bitbucket) con el código fuente y script de creación de BD.

● Readme explicando cómo probarlo.

● Diagrama de la solución.

#### Requisitos opcionales

● JWT como token

● Pruebas unitarias

● Swagger


### Used Technologies
- [JDK 17](https://www.oracle.com/index.html)
- [Spring Boot](https://projects.spring.io/spring-boot/)
- [Spring JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [H2 Database](https://www.h2database.com/)
- [jUnit](http://junit.org/junit5/)
- [Mockito](http://site.mockito.org/)
- [Gradle](https://gradle.org/)
- [Swagger](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)


### Comments
Se desarrolla la api en dos modulos principales, los cuales se componen de:
1. Api Rest Principal (Operaciones Rest)
2. Almacenamiento en BD de memoria (H2 Database)

Se ingresa por el Api Principal, la cual tiene la operacion POST responsable validar, capturar y almacenar la informacion en la peticion 

H2 Database se levanta con su modulo administrativo de esta manera podemos ver como se estan almacenando los datos. Se debe aclarar que una vez se baja el servidor, todos los datos almacenados desaparacen.

Ejemplo:
```
curl -X POST "http://35.175.126.169:8080/users" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"mail\": \"juankart@hotmail.es\", \"name\": \"Daniela Florez\", \"password\": \"Jcar1983\", \"phones\": [ { \"cityCode\": \"01\", \"countryCode\": \"21\", \"number\": \"3044491800\" },{ \"cityCode\": \"01\", \"countryCode\": \"21\", \"number\": \"3002213076\" },{ \"cityCode\": \"01\", \"countryCode\": \"21\", \"number\": \"3044491802\" } ]}"
```

### Setup
#### Instruccions
Se deben tener instaladas todas las dependencias mencionadas para las tecnologias usadas

Abrir el Proyecto Adjunto nisum-api y ejecutar el proyecto desde su clase principal NisumApiApplication.java


### API Url
URL Local: http://35.175.126.169:8080/V1/users

URL Swagger: http://35.175.126.169:8080/swagger-ui.html#

URL H2 DB: http://localhost:8080/h2-console

### Endpoints
POST http://35.175.126.169:8080/V1/users {JSON}

GET http://35.175.126.169:8080/V1/users


### Services
#### Swagger
http://35.175.126.169:8080/swagger-ui.html#/

### Test
#### UnitTest

Para la ejecucion de los test unitarios utilice jUnit.

#### Coverage

Para la cobertura de código se utilizó la herramienta Codecov, muestra un 73% de coverage. No se abarcan mas pruebas teniendo en cuenta el tiempo para el desarrollo, solo son un ejemplo de su uso
