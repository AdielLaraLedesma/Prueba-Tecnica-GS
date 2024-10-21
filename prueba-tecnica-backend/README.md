Para levantar el servicio es necesario seguir los siguientes pasos
1.- Ubicarse en la raiz del proyecto
2.- Ejecutar en consola el comando "mvn clean install"
2.- Ejecutar en consola "docker build -t prueba-tecnica-backend ."
3.- Levantar el servicio con "docker run -d --network prueba-tecnica-net --name pruebatecnicabackend -p 8080:8080 prueba-tecnica-backend"