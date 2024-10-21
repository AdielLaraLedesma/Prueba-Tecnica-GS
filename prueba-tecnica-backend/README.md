# PRUEBA-TECNICA-BACKEND

---

## _prueba_tecnica_backend
### Descripcion:
Es un microservicio que permite generar solicitudes de credito, la cual puede ser rechazada o aprobada
También, permite realizar la simulación de varias peticiones de credito, especificando el numero de iteraciones
Y permite obtener el total de peticiones que fueron aprobadas y que fueron rechazadas

## Versionado
Este servicio se encuentra versionado en un repositorio de github

HTTP:
``` https://github.com/AdielLaraLedesma/Prueba-Tecnica-GS.git ``` - [Link](https://github.com/AdielLaraLedesma/Prueba-Tecnica-GS.git)

**_NOTA_**: El repositorio estará publico para su revision.

---

## ** Caracteristicas**
- Microservicio que expone un API REST
- Microservicio que se encarga de generar creditos y obtener la sumatoria de peticiones que fueron aprobadas y rechazadas.
- Uso de Maven como herramienta para manejo de pendencias
- Uso de SQL Server como base de datos.

---

## TABLA DE PROPIEDADES
| Propiedad                                     | Funcionalidad                                                                              | Ejemplo                                                                                                           |
|-----------------------------------------------|--------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
| server.port                                   | Puerto donde se levantará el servicio.                                                     | server.port=8080                                                                                                  |
| spring.application.name                       | Nombre del servicio.                                                                       | spring.application.name=prueba-tecnica-backend                                                                    |
| spring.datasource.url                         | Propiedad para indicarle la ruta de conexión a la base de datos.                           | spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=creditDB;TrustServerCertificate=True;          |
| spring.datasource.username                    | Propiedad para indicarle el usuario que se utiliza para conectarse a la base de datos.     | spring.datasource.username=creditUser                                                                             |
| spring.datasource.password                    | Propiedad para indicarle la contraseña que se utiliza para conectarse a la base de datos.  | spring.datasource.password=seCret01*1                                                                             |
| spring.jpa.show-sql                           | Propiedad para indicarle si mostrar las consultas SQL que se realicen en la base de datos. | spring.jpa.show-sql=false                                                                                         |
| spring.jpa.hibernate.naming.implicit-strategy | Propiedad para indicarle la estrategia de nombrado.                                        | spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl |
| spring.jpa.hibernate.naming.physical-strategy | Propiedad para indicarle la estrategia de nombrado.                                        | spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl  |
| spring.jpa.properties.hibernate.dialect       | Propiedad para indicarle el dialecto de la base de datos.                                  | spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServerDialect                                    |
| ms.cors.origin                                | Propiedad para indicarle la url del frontend que consumira el microservicio.               | ms.cors.origin=http://127.0.0.1:5500                                                                              |


## Instalacion
La instalación de este servicio se hará en Docker siguiendo los siguientes pasos:
- Ubicarse en la raiz del proyecto `prueba-tecnica-backend`
- Ejecutar en consola el comando `mvn clean install`
- Ejecutar en consola `docker build -t prueba-tecnica-backend .`
- Levantar el servicio con `docker run -d --network prueba-tecnica-net --name pruebatecnicabackend -p 8080:8080 prueba-tecnica-backend`

**_NOTA_**: Antes de ejecutar los comandos antes mencionados es necesario tener una red llamada "prueba-tecnica-net" para eso debes de ejecutar el siguiente comando:
`docker network create prueba-tecnica-net`

## Pruebas
Para realizar pruebas a este servicio se asume que el microservicio ya esta desplegado en Docker o levantado en local

La colección de postman se encuentra en la carpeta "postman-collection"