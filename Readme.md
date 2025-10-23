**Nombre y apellidos**: Hanane Boughroum Hamdach

# Proyecto RESTFull - Gestión de Productos

Este proyecto permite **gestionar productos**, pudiendo **añadir, listar, editar y eliminar** información de cada uno de ellos. 

Se ha desarrollado con **Spring Boot** y organiza el código en diferentes partes para mantenerlo limpio y fácil de entender

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
        ├── mapper
        └── web
```
