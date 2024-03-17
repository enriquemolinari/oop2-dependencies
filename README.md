# Técnicas de Desacoplamiento en Objetos

- Inyección de Dependencias
- Ejemplo Export
    - Path al archivo hardcodeado
    - Dependencia en Users hardcodeada
    - Dependencia en exportar a Archivo hardcodeada
    - ¿Cómo testeo? Acoplado a todo esto. No es bueno.
        - No tengo buen control
        - Acceso a disco es lento
- Ejemplo Pagos Online
    - URL hardcodeada
    - Tipo de pago hardcodeado
    - ¿Cómo lo testeo sin cobrar de verdad?
- Depender de Abstracciones
- Desacoplar lógica de negocios de detalles técnicos
- A que denominamos detalle técnico:
    - Acceso al disco (leer o escribir archivos)
    - Acceso al teclado
    - Acceso a una Base de Datos (JDBC)
    - Consumo de servicios Web
    - Enviar de emails, imprimir, etc.
- Testing del modelo desacoplado de detalles técnicos

- Sandy Metz about Minimalist Testing
    - https://www.youtube.com/watch?v=URSWYvyc42M