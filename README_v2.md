# Park4U – Gestor de Parqueadero Multinivel

## Descripción del Proyecto

Park4U es un sistema de gestión de parqueadero multinivel diseñado para facilitar el registro de entradas y salidas de vehículos, calcular tarifas y descuentos, y generar reportes de uso. Este sistema está desarrollado en Java y utiliza `JOptionPane` para la interacción con el usuario.

## Estructura del Proyecto

El proyecto está organizado en la siguiente estructura de directorios:

```
Park4U
├── src
│   ├── Main.java
│   ├── models
│   │   ├── Vehicle.java
│   │   ├── ParkingTicket.java
│   │   └── Membership.java
│   ├── services
│   │   ├── ParkingService.java
│   │   ├── PaymentService.java
│   │   └── ReportService.java
│   └── utils
│       ├── InputValidator.java
│       └── TimeCalculator.java
├── lib
└── README.md
```

## Instrucciones de Configuración

1. **Requisitos Previos**: Asegúrate de tener instalado Java Development Kit (JDK) en tu máquina.
2. **Compilación**: Navega al directorio `src` y compila los archivos Java utilizando el siguiente comando:
   ```
   javac *.java models/*.java services/*.java utils/*.java
   ```
3. **Ejecución**: Ejecuta el programa utilizando el siguiente comando:
   ```
   java Main
   ```

## Uso

Al iniciar el programa, se presentará un menú con las siguientes opciones:

1. Registrar ingreso de vehículo
2. Registrar salida y cobrar
3. Gestionar membresías
4. Generar reportes
5. Ver caja
6. Salir

Sigue las instrucciones en pantalla para interactuar con el sistema.

## Funcionalidades

- **Ingreso y salida de vehículos**: Permite registrar la entrada y salida de vehículos, calculando automáticamente las tarifas correspondientes.
- **Membresías**: Gestiona la alta, consulta y cancelación de membresías para usuarios frecuentes.
- **Reportes**: Genera reportes sobre la ocupación del parqueadero y los ingresos generados.
- **Validaciones**: Incluye validaciones para asegurar que los datos ingresados sean correctos.

## Casos de Prueba

Se han definido varios casos de prueba para asegurar el correcto funcionamiento del sistema, incluyendo:

1. Cobro diurno simple.
2. Redondeo por fracción de hora.
3. Recargos por nocturnidad y fines de semana.
4. Aplicación de descuentos.
5. Manejo de membresías activas.
6. Multas por pérdida de ticket.
7. Generación de reportes.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas colaborar, por favor abre un issue o envía un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT.