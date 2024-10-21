## Instalacion
La instalación de este servicio se hará en Docker siguiendo los siguientes pasos:
- Ubicarse en la raiz del proyecto `prueba-tecnica-frontend`
- Ejecutar en consola `docker build -t prueba-tecnica-frontend .`
- Levantar el servicio con `docker run -d --network prueba-tecnica-net --name pruebatecnicafrontend -p 80:80 prueba-tecnica-frontend`

**_NOTA_**: Antes de ejecutar los comandos antes mencionados es necesario tener una red llamada "prueba-tecnica-net" para eso debes de ejecutar el siguiente comando:
`docker network create prueba-tecnica-net`

Una vez seguido esos pasos podemos dirigirnos a la ruta
``` http://localhost:80 ``` - [Link](http://localhost:80)