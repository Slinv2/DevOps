# DevOps @ FHV

Willkommen zur Dokumentation des DevOps Projekts von **Team ryannilsemiliemelsimyurt**.

Diese Seite wird mit [MkDocs](https://www.mkdocs.org/) und dem
[Material for MkDocs](https://squidfunk.github.io/mkdocs-material/) Theme erzeugt
und über einen [nginx](https://hub.docker.com/_/nginx) Container ausgeliefert.

## Projektüberblick

- Spring Boot Anwendung, gebaut mit Gradle im Container
- CI/CD Pipeline auf einem self-hosted Build-Agent
- Statische Code-Analyse mit SonarQube
- Containerisierung der Anwendung und der Dokumentation
- Push der Images in die Team-Registry

## Build-Schritte

| Schritt            | Container              | Ergebnis                          |
| ------------------ | ---------------------- | --------------------------------- |
| Gradle Build       | `gradle:jdk17`         | `.jar` Datei                      |
| Dokumentation      | `squidfunk/mkdocs-material` | `site/` Ordner (HTML)        |
| Anwendungs-Image   | `eclipse-temurin:17-jre` | lauffähige App                  |
| Dokumentations-Image | `nginx`              | ausgelieferte HTML-Dokumentation  |

Die laufenden Notizen findest du unter [Notizen](notes.md).
