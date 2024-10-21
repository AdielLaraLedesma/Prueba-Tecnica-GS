## Instalacion
La instalación de SQL SERVER se hará en Docker siguiendo los siguientes pasos:
- Ubicarse en la raiz del proyecto `base-datos`
- Ejecutar en consola `docker-compose up --build -d`
- Acceder a la base de datos con algun manejador, ya sea "SQL Server Managment" o "DBeaver", utilizando el usuario `sa` y la contraseña `passWord-12345*`
- Ejecutar el script `setup.sql`
- Ejecutar el script `carga-inicial.sql`

**_NOTA_**: Antes de ejecutar los comandos antes mencionados es necesario tener una red llamada "prueba-tecnica-net" para eso debes de ejecutar el siguiente comando:
`docker network create prueba-tecnica-net`

