**Nombre y apellidos**: Hanane Boughroum Hamdach

# Proyecto RESTFull - Gestión de Productos

Este proyecto permite **gestionar productos categorías** pudiendo: 
- Añadir productos y categorías
- Listar productos y categorías
- Editar productos y categorías
- Eliminar productos y categorías

Se ha desarrollado con **Spring Boot** y organiza el código en diferentes partes para mantenerlo limpio y fácil de entender

Además, se ha incorporado **caché en memoria** para mejorar el rendimiento de datos frecuentes. (la rama *005_categoria_producto*)

- Usando el **vertical slicing**, tenemos la siguiente estructura en el proyecto: 

```bash
    productos
    ├── application 
    │   ├── command
    │   ├── service
    │   └── usecase
    ├── domain
    │   ├── model
    │   ├── repository
    │   └── error
    └── infraestructure
        ├── config
        ├── db
            └── repository
                └── mock
        ├── mapper
        └── web
            ├── dto
            └── rest

    RestfullApplication.java
```
