# CODEBASE.md

Este documento describe la arquitectura y estructura del código fuente del proyecto. Cada paquete tiene una función claramente definida y responde a principios de organización estrictos para facilitar la mantenibilidad, escalabilidad y claridad del sistema.

---

### `act/` — Lógica operativa del sistema

El paquete `act/` contiene las clases que implementan la lógica funcional central del sistema. Estas clases procesan datos, coordinan comportamientos y ejecutan operaciones clave del programa. Se caracterizan por estar desacopladas de cualquier componente visual (como `Swing`) o de terminal (como `System.in` / `System.out`).

Las clases dentro de este paquete pueden interactuar con:
- Atributos definidos en `att/`.
- Utilidades generales desde `util/`.
- Excepciones personalizadas desde `ex/`.

No deben contener lógica de presentación ni visualización de datos. La responsabilidad de estas clases es puramente funcional.

**Reglas:**
- No deben heredar de componentes visuales ni usar clases de GUI o consola.
- Pueden contener constructores, métodos internos y llamadas a clases de atributos, utilidades o excepciones.
- Si ejecutan carga de interfaces, debe ser por métodos encapsulados, sin implementar lógica visual directamente.

**Ejemplos reales:**
- `BinaryConverter.java`: lógica de conversión binaria/decimal.
- `WindowLoader.java`: encapsula la carga de interfaces gráficas sin lógica visual directa.

---

### `att/` — Clases de atributos

El paquete `att/` agrupa las clases que representan configuraciones, constantes, parámetros o cualquier entidad de datos sin comportamiento lógico. Estas clases contienen variables de instancia protegidas o públicas, y sus respectivos métodos de acceso (getters y setters).

**Reglas:**
- No deben tener lógica funcional.
- Deben tener un constructor si contienen inicializaciones.
- Las variables deben ser `protected` por defecto, salvo excepciones justificadas.

**Ejemplos reales:**
- `AppearanceSettings.java`: contiene valores RGB para la interfaz.
- `SystemInfo.java`: contiene versión del sistema y número de referencia.

---

### `cmd/` — Comandos de terminal y lanzadores

Este paquete contiene clases que se ejecutan en consola o lanzan la aplicación. Suelen contener métodos `main()` y utilizar flujos de entrada/salida de terminal (`Scanner`, `System.out`).

**Reglas:**
- Pueden utilizar la consola como entrada o salida.
- No deben contener GUI directamente, aunque pueden invocar cargadores visuales (como `WindowLoader`).
- Pueden depender de `att/`, `act/`, `util/` y `ex/`.

**Ejemplos reales:**
- `CommandConsole.java`: ejecución basada en comandos por consola.
- `ApplicationLauncher.java`: lanza la aplicación e inicia componentes.

---

### `gui/` — Interfaz gráfica del sistema

Este paquete contiene todas las clases visuales construidas con Swing. Aquí residen los cuadros de diálogo, ventanas, menús, y cualquier componente que interactúe gráficamente con el usuario.

**Reglas:**
- Las clases deben heredar de `JFrame`, `JPanel` o contener componentes visuales.
- Pueden importar clases de `att/` (por ejemplo, configuraciones de apariencia).
- No deben contener lógica funcional profunda, solo la relacionada a la vista.

**Ejemplos reales:**
- `AboutDialog.java`, `LicenseDialog.java`, `AppearanceSettingsEditor.java`: ventanas modales informativas o configurables.
- `MainControlPanel.java`: panel principal de control de la aplicación.
- `MainControlHandler.java`: clase de eventos y control de interfaz para `MainControlPanel`.

---

### `util/` — Utilidades generales del sistema

Contiene funciones auxiliares reutilizables y genéricas. Son independientes de la lógica del dominio y de cualquier entrada/salida, ya sea visual o por consola.

**Reglas:**
- Las clases deben ser `final` y tener constructor privado.
- Todos los métodos deben ser `static`.
- No deben importar componentes visuales ni de consola.
- Deben tener pruebas correspondientes en `test/`.
- Si el paquete crece, se puede subdividir en subpaquetes (ej. `util/io`, `util/math`).

**Ejemplo estructural:**
```java
public final class StringUtils {
    private StringUtils() {}
    public static String capitalize(String input) { ... }
}
```

### `test/` — Pruebas del sistema

Este paquete contiene todas las pruebas unitarias, funcionales e integradas. Toda clase en `src/` debe tener su clase de prueba correspondiente en `test/`, con el mismo nombre seguido del sufijo `Test`.

**Reglas:**

- Deben utilizar un framework de pruebas (**JUnit recomendado**).
- Cada método debe probar un único comportamiento.
- Las pruebas deben ser deterministas y sin efectos secundarios.
- Deben cubrir casos base, casos límite y casos nulos o erróneos.

**Ejemplo estructural:**

```java
@Test
public void testCapitalizeWithValidInput() {
    assertEquals("Hola", StringUtils.capitalize("hola"));
}
```

### `ex/` — Excepciones personalizadas

Este paquete contiene clases que definen errores específicos del sistema. Permiten capturar, lanzar y documentar fallos controlados con semántica propia.

**Reglas:**

- Todas las clases deben terminar en `Exception`.
- Deben extender `Exception` o `RuntimeException`.
- No deben contener lógica funcional.
- Deben incluir constructores con mensaje personalizado, y opcionalmente, con causa (`Throwable`).

**Ejemplo estructural:**

```java
public class InvalidUserInputException extends Exception {
    public InvalidUserInputException(String message) {
        super(message);
    }

    public InvalidUserInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
```
Este CODEBASE.md se actualizará conforme se integren nuevos paquetes o se redefinan responsabilidades de clases específicas.
