# Reto: **Park4U – Gestor de Parqueadero Multinivel**

## Problemática

La ciudad tiene un parqueadero de 4 niveles que cobra por tipo de vehículo y franjas horarias. Deben construir un sistema en Java que use exclusivamente `JOptionPane` para registrar entradas y salidas, calcular tarifas y descuentos, emitir comprobantes en pantalla, generar reportes de turno y controlar un flujo básico de caja.

---

## Alcance funcional

1. **Ingreso de vehículo**

   * Datos: placa, tipo (`MOTO`, `CARRO`, `CAMIONETA`), nivel (1–4), hora de entrada en formato `HH:mm`.
   * Validaciones con máximo 3 intentos por campo. Si se superan, cancelar la operación.

2. **Salida y cobro**

   * Datos: placa y hora de salida.
   * Tarifa base por hora con redondeo al alza si la fracción es mayor o igual a 15 minutos:

     * MOTO: 2.500
     * CARRO: 4.000
     * CAMIONETA: 5.500
   * Recargos:

     * Nocturno (≥ 21:00 o < 06:00): +15% sobre el total.
     * Fines de semana (sábado y domingo): +10%.
   * Descuentos, aplicando solo el mayor:

     * Convenio Empresa: 12%
     * Residente Nivel: 10%
     * EcoVehículo: 8%
   * Pérdida de ticket: multa fija de 20.000 más un cobro estimado de 2 horas mínimo.

3. **Membresías mensuales**

   * Planes: BASICO (80.000), PLUS (120.000), PREMIUM (180.000).
   * Si la placa tiene membresía activa, el cobro por hora es 0.
   * Se debe permitir alta, consulta y cancelación de membresías por placa.

4. **Caja**

   * Mostrar subtotales por tipo de vehículo, cantidad de tickets cobrados, multas, descuentos aplicados, recargos aplicados y total del turno.
   * Permitir cerrar turno y reiniciar acumulados manteniendo las membresías.

5. **Reportes**

   * Top 3 placas con más ingresos en el día.
   * Ocupación por nivel con capacidad fija: Nivel 1 = 30, Nivel 2 = 40, Nivel 3 = 40, Nivel 4 = 50.
   * Promedio de horas por tipo de vehículo en las salidas registradas.

---

## Criterios de aceptación

1. La entrada y salida de datos se realiza exclusivamente con `JOptionPane`.
2. Cada validación tiene máximo 3 intentos; si no se logra, se cancela la operación con un mensaje.
3. El menú principal funciona en bucle hasta seleccionar la opción de salir:

   * Registrar ingreso
   * Registrar salida y cobrar
   * Membresías
   * Reportes
   * Caja
   * Salir
4. El cálculo tarifario aplica redondeos, recargos y descuentos de forma correcta.
5. En cada salida se genera un comprobante con placa, tipo, horas, tarifa base, recargos, descuentos y total.
6. Los reportes deben calcularse durante la ejecución.
7. El código debe estar organizado con métodos o clases simples.
8. Debe existir un README con guía de uso, reglas de negocio, casos de prueba y decisiones de diseño.

---

## Casos de prueba

1. **Cobro diurno simple**

   * CARRO, entrada 10:10, salida 12:05 → 1h55m → 2 horas → Total 8.000

2. **Redondeo por fracción**

   * MOTO, entrada 14:00, salida 15:10 → 1 hora
   * MOTO, entrada 14:00, salida 15:20 → 2 horas

3. **Nocturno y fin de semana**

   * CAMIONETA, sábado, entrada 21:10, salida 23:05
   * Base: 2h × 5.500 = 11.000
   * Recargos: nocturno +15%, fin de semana +10%

4. **Descuento mayor**

   * Convenio 12% y Residente 10% → aplicar 12%

5. **Membresía activa**

   * Placa con plan PLUS → no cobra por hora

6. **Pérdida de ticket**

   * Multa 20.000 + mínimo 2 horas

7. **Reportes**

   * Validar top 3 placas, ocupación y promedios por tipo con múltiples registros

---