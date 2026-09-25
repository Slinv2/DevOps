# Basis-Image mit Java 17 Laufzeitumgebung
FROM eclipse-temurin:17-jre

# Arbeitsverzeichnis im Container festlegen
WORKDIR /app

# Die gebaute JAR-Datei in den Container kopieren
COPY build/libs/*.jar app.jar

# Befehl zum Starten der Anwendung
ENTRYPOINT ["java", "-jar", "app.jar"]