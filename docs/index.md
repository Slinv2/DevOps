# DevOps @ FHV

Welcome to the documentation of the DevOps project by **Ryan Emilie Melsim Nils**.
Hiiiiiii whats up, u like our documentation.

This site is build with [MkDocs](https://www.mkdocs.org/) and the
[Material for MkDocs](https://squidfunk.github.io/mkdocs-material/) theme,
and served through an [nginx](https://hub.docker.com/_/nginx) container.

## Project overview

- Spring Boot application, built with Gradle inside a container
- CI/CD pipeline running on a self-hosted build agent
- Static code analysis with SonarQube
- Containerization of the application and the documentation
- Pushing the images to the team registry

## Build steps

| Step                 | Container                   | Result                         |
| -------------------- | --------------------------- | ------------------------------ |
| Gradle build         | `gradle:jdk17`              | `.jar` file                    |
| Documentation        | `squidfunk/mkdocs-material` | `site/` folder (HTML)          |
| Application image    | `eclipse-temurin:17-jre`    | runnable app                   |
| Documentation image  | `nginx`                     | served HTML documentation      |

You can find the ongoing notes under [Notes](notes.md).
