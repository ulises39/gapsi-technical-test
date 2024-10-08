
# Prueba Técnica Gapsi

Este proyecto fue elaborado como solución para la prueba técnica solicitada. 
Tecnologías utilizadas: 

- Java
- Spring Boot
- Maven
- Docker
- PostgreSQL

# Detalles del despliegue
Este proyecto se desplegó utilizando Google Cloud Platform haciendo uso de Cloud SQL y Cloud Engine. 
La URL base para acceder a la API es el siguiente: 
```
https://gapsi-technical-test-326229923178.us-central1.run.app/api/
```

# Configuración del proyecto
1. Para configurar el proyecto es necesario copiar el archivo `.env.example` y renombrarlo como `.env`
2. Las variables deben configurarse de la siguiente manera: 
```
EXEC_PORT=8080 #Puerto de ejecución para el proyecto
DB_URL=jdbc:postgresql://<HOST>:<PORT>/<DB_NAME> #Url de la base de datos
DB_USERNAME= #Usuario de la base de datos
DB_PASSWORD= #Contraseña para el usuario de la base de datos
```

3. Una vez configurado el entorno hay que compilar el proyecto:
```
mvn clean install -DskipTests -DoutputDirectory=/target
```
4. Finalmente, se ejecuta con el comando:
```
java -jar .\target\technical-test-0.0.1-SNAPSHOT.jar
```

## Referencia API
NOTA: Para más detalles, revisar el archivo `openapi.yml` o `openapi.json`

#### Obtener todos los productos

```http
  GET /api/products
```
#### Obtener un producto en específico

```http
  GET /api/products/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `UUID` | **Requerido**. Id de un producto |

#### Crear un producto

```http
  POST /api/products
```
```jsonc
{
    "name": "string", // Nombre del producto
    "description": "string", // Descripción del producto
    "model": "string", // Modelo del producto
    "price": float // Precio del producto. Debe ser un número con dos decimales
}
```

#### Actualizar un producto
Dados los requisitos, solamente se puede actualizar la descripción y modelo del producto, esto es:

```http
  PUT /api/products{id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `UUID` | **Requerido**. Id de un producto |

```jsonc
{
    "description": "string", // Descripción del producto
    "model": "string", // Modelo del producto
}
```

