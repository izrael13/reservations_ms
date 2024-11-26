# Hotel Reservations Microservices

Este proyecto consiste en una serie de **microservicios** para gestionar las reservas de cuartos en un hotel. Los microservicios están diseñados para ser escalables, resilientes y seguros, y utilizan una variedad de tecnologías como Spring Boot, Eureka, Resilience4j, y OAuth2 para proporcionar un sistema de reservas robusto y distribuido.

## Tecnologías Utilizadas

- **Java 17**: Lenguaje de programación principal.
- **Spring Boot**: Framework para construir aplicaciones Java basadas en microservicios.
- **Eureka**: Servidor de descubrimiento de microservicios.
- **Config Server**: Para configuración global compartida entre los microservicios.
- **RestTemplate & Feign**: Para la comunicación entre microservicios.
- **Resilience4j**: Gestión de fallos con **Circuit Breaker** y **Retry** para garantizar la resiliencia.
- **Sleuth & Zipkin**: Para la trazabilidad distribuida y monitoreo de las peticiones entre microservicios.
- **OAuth2**: Seguridad en las aplicaciones para el manejo de autenticación y autorización.
- **Docker & Docker Compose**: Contenerización y orquestación de los servicios.

## Funcionalidades

- **Gestión de Reservas**: Creación, actualización y cancelación de reservas de habitaciones.
- **Autenticación y Autorización**: Utiliza OAuth2 para la seguridad de las aplicaciones.
- **Descubrimiento de Servicios**: Eureka permite que los microservicios se descubran entre sí.
- **Resiliencia**: Los microservicios cuentan con mecanismos para gestionar fallos y reintentos.
- **Trazabilidad**: Con Sleuth y Zipkin, se puede rastrear el flujo de peticiones entre microservicios.

## Requisitos Previos

Asegúrate de tener los siguientes programas instalados:

- **Java 17** o superior
- **Docker** y **Docker Compose** (para ejecutar los servicios en contenedores)
- **Maven** o **Gradle** para la gestión de dependencias

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/izrael13/reservations_ms.git
   cd reservations_ms

   Seguridad

El acceso a las APIs está asegurado mediante OAuth2. Asegúrate de autenticarte correctamente para obtener un token antes de realizar peticiones a las APIs protegidas.
Resiliencia

Gracias a Resilience4j, el sistema es capaz de manejar fallos a través de Circuit Breakers y Retry. Si un servicio falla, el sistema intentará reintentar la operación y, en caso de que no se recupere, abrirá el circuito y evitará la propagación del fallo.
Trazabilidad

La trazabilidad distribuida está habilitada a través de Sleuth y Zipkin, lo que permite monitorear y rastrear las peticiones a través de todos los microservicios.
Contribución

Las contribuciones son bienvenidas. Si deseas contribuir a este proyecto, por favor sigue estos pasos:

    Haz un fork del repositorio.
    Crea una rama para tu característica (git checkout -b feature/nueva-característica).
    Realiza los cambios y haz un commit.
    Haz un push a tu repositorio remoto y abre un Pull Request.

