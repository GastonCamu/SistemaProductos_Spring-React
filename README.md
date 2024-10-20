# Como establecer en anonimo un archivo en github dejando un default

1. Subir con el default tal cual a github
2. Agregar la ruta al archivo .gitignore
3. Colocar el siguiente comando para quitar el seguimiento de futuras actualizaciones en el mismo archivo: git update-index --assume-unchanged src/main/resources/application.properties.
