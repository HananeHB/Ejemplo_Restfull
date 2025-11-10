**Nombre y apellidos**: Hanane Boughroum Hamdach

# Gestión de Productos y Categorías

Se permite **gestionar productos y categorías** pudiendo: 
- Crear , listar, editar y eliminar **productos**
- Crear , listar, editar y eliminar **Categorías**


Se ha desarrollado con **Spring Boot** y organiza el código en diferentes partes para mantenerlo limpio y fácil de entender

Además, se ha incorporado **caché en memoria** para mejorar el rendimiento de datos frecuentes. (la rama *005_categoria_producto*)

- Usando el **vertical slicing**, tenemos la siguiente estructura en el proyecto: 

```bash
    common
    ├── domain
    │   ├── error
    │   ├── model
    │   └── repository 
    └── infraestructure 
        └── web
            └──   error
        
    productos
    ├── application 
    │   ├── command
    │   │  ├── categoria
    │   │  └── peoducto
    │   ├── service
    │   │  ├── categoria
    │   │  └── peoducto
    │   └── usecase
    │   │  ├── categoria
    │   │  └── peoducto
    ├── domain
    │   ├── model
    │   ├── repository
    │   └── error
    └── infraestructure
        ├── config
        ├── db
        │  ├── categoria
        │  └── peoducto
        ├── mapper
        └── web
            ├── dto
            ├── rest
            └── validation
        
    RestfullApplication.java
```
