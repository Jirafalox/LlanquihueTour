# LlanquihueTour
Repositorio de la entrega de la evaluación de la semana 3 de la primera experiencia de la asignatura Programación Orientada a Objetos.


![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Evaluación Experiencia 1 Semana 3  – Desarrollo Orientado a Objetos I

## 👤 Autor del proyecto
- **Nombre completo:** Ignacio Sebastian Mellado Riquelme
- **Carrera:** Programación orientada a Objetos
- **Sede:** Campus Virtual

---

## 📘 Descripción general del sistema
Este proyecto corresponde a la Primera y Segunda Evaluaciónde la asignatura *Desarrollo Orientado a Objetos I*. Se trata de un sistema básico orientado a objetos que representa las personas vinculadas a la agencia de turismo Llanquihue Tour, aplicando creación de objetos, encapsulamiento, herencia y composición.


El proyecto fue desarrollado a partir de un caso contextualizado, abordando problemáticas reales y proponiendo una solución estructurada, modular, escalable y reutilizable.

---

## 🧱 Estructura general del proyecto

LlanquihueTourApp/
├── app/
│   └── Main.java
├── model/
│   ├── Direccion.java
│   ├── Persona.java
│   └── Empleado.java
├── service/
│   └── EmpleadoService.java
├── util/
│   └── ArchivoUtil.java
├── empleados.csv
└── README.md
---



# LlanquihueTourApp

Aplicación de consola para gestionar empleados de una empresa de turismo en la región de Llanquihue.
Este proyecto corresponde a la actividad de la Semana 5 de Desarrollo Orientado a Objetos I en Duoc UC.

## Paquetes utilizados

- `model` – Clases del dominio (Direccion, Persona, Empleado)
- `service` – Lógica de negocio (EmpleadoService)
- `util` – Utilidades de lectura de archivos (ArchivoUtil)
- `app` – Clase principal del programa (Main)

## Clases implementadas

- `Direccion` – Composición usada por Empleado
- `Persona` – Clase base con atributos comunes
- `Empleado` – Hereda de Persona, incluye cargo y dirección
- `EmpleadoService` – Gestiona la lista de empleados con ArrayList
- `ArchivoUtil` – Lee archivos .csv usando FileReader y BufferedReader
- `Main` – Punto de entrada de la aplicación

## Instrucciones para ejecutar

1. Asegúrate de tener el archivo `empleados.csv` en la raíz del proyecto (al mismo nivel que las carpetas `model`, `util`, etc.).
2. Compila todos los archivos desde la raíz del proyecto:

```bash
javac model/*.java util/*.java  app/*.java
```

3. Ejecuta la clase principal:

```bash
java app.Main
```

4. El programa cargará los empleados desde el CSV, los mostrará en consola y realizará una búsqueda por nombre.
