Para levantar el servicio es necesario seguir los siguientes pasos
1.- Ubicarse en la raiz del proyecto
2.- Ejecutar en consola "docker build -t prueba-tecnica-frontend ."
3.- Levantar el servicio con "docker run -d --network prueba-tecnica-net --name pruebatecnicafrontend -p 80:80 prueba-tecnica-frontend"