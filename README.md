# PostContenido 2 - Unidad 7

API REST CRUD de productos desarrollada con Spring Boot para el curso de Programacion Web. Este proyecto reutiliza la base del `postcontenido1`, pero reemplaza las vistas MVC por endpoints REST que responden en formato JSON.

## Objetivo

Implementar una API REST para gestionar productos en memoria, aplicando operaciones CRUD y devolviendo los codigos HTTP correctos en cada caso.

## Tecnologias usadas

- Java 17
- Spring Boot 3.5.13
- Maven
- Spring Web
- Spring Boot DevTools

## Estructura del proyecto

```text
src/main/java/com/universidad/productosweb
├── ProductosWebApplication.java
├── controller
│   ├── GlobalExceptionHandler.java
│   └── ProductoApiController.java
├── model
│   └── Producto.java
└── service
    └── ProductoService.java

src/main/resources
├── application.properties
└── templates
    └── productos
```

## Descripcion de componentes

- `ProductosWebApplication`: clase principal que inicia la aplicacion Spring Boot.
- `Producto`: modelo con los atributos `id`, `nombre`, `descripcion` y `precio`.
- `ProductoService`: servicio que simula la persistencia con una coleccion en memoria y contiene la logica CRUD.
- `ProductoApiController`: controlador REST que expone los endpoints de la API bajo la ruta `/api/productos`.
- `GlobalExceptionHandler`: manejador global de excepciones para devolver errores en formato JSON.

## Ejecucion del proyecto

1. Abrir una terminal en la carpeta del proyecto.
2. Ejecutar el siguiente comando:

```bash
mvn spring-boot:run
```

Tambien se puede compilar y empaquetar con:

```bash
mvn clean package
```

La aplicacion inicia en:

```text
http://localhost:8080
```

## URL base de la API

```text
http://localhost:8080/api/productos
```

## Endpoints disponibles

### 1. Listar productos

- Metodo: `GET`
- URL: `http://localhost:8080/api/productos`
- Respuesta esperada: `200 OK`

### 2. Buscar producto por ID

- Metodo: `GET`
- URL: `http://localhost:8080/api/productos/{id}`
- Respuesta esperada:
  - `200 OK` si existe
  - `404 Not Found` si no existe

### 3. Crear producto

- Metodo: `POST`
- URL: `http://localhost:8080/api/productos`
- Header: `Content-Type: application/json`
- Body de ejemplo:

```json
{
  "nombre": "Monitor",
  "descripcion": "Monitor 27 pulgadas 4K",
  "precio": 499.99
}
```

- Respuesta esperada: `201 Created`

### 4. Actualizar producto

- Metodo: `PUT`
- URL: `http://localhost:8080/api/productos/3`
- Header: `Content-Type: application/json`
- Body de ejemplo:

```json
{
  "nombre": "Monitor Curvo",
  "descripcion": "Monitor curvo 32 pulgadas QHD",
  "precio": 699.99
}
```

- Respuesta esperada:
  - `200 OK` si existe
  - `404 Not Found` si no existe

### 5. Eliminar producto

- Metodo: `DELETE`
- URL: `http://localhost:8080/api/productos/3`
- Respuesta esperada:
  - `204 No Content` si existe
  - `404 Not Found` si no existe

## Manejo de errores

Cuando se solicita un producto que no existe, la API responde con codigo `404` y un cuerpo JSON como el siguiente:

```json
{
  "error": "Producto no encontrado: 999"
}
```

## Datos iniciales

El servicio carga tres productos de ejemplo al iniciar:

- Laptop
- Mouse
- Teclado

Esto permite probar el endpoint `GET /api/productos` desde el primer arranque.

## Pruebas realizadas

Se verifico correctamente:

- `mvn clean package`
- carga del contexto Spring Boot
- endpoints CRUD para listar, crear, actualizar y eliminar productos



Ejemplo de nombres sugeridos para las imagenes:

- `docs/get-productos.png`
- `docs/post-producto.png`
- `docs/put-producto.png`
- `docs/delete-producto.png`
- `docs/get-error-404.png`

## Autor

- Estudiante: Jair Sanjuan
- Curso: Programacion Web
- Unidad: 7
