# SF-Lab

> A multi-module lab for studying the Spring Framework ecosystem, from security to data, web, and beyond.

---

## About

SF-Lab is a Gradle multi-module project designed for hands-on exploration of the Spring Framework ecosystem. Each module focuses on a specific Spring topic and contains isolated, runnable examples with notes.

The goal is not to build a production application, but to deeply understand how each part of the ecosystem works, independently and together.

---

## Modules

| Module                 | Topic | Description | Status |
|------------------------|---|---|---|
| [Security](./Security) | Spring Security | Application-level security: authentication, authorization, JWT, OAuth2 | 🔄 In Progress |

---

## Tech Stack

- **Java 21**
- **Spring Boot 3.x**
- **Gradle** (multi-module)

---

## Project Structure

```
SF-Lab/
├── Security/        # Spring Security labs
├── build.gradle
└── settings.gradle
```

---

## Getting Started

```bash
git clone https://github.com/your-username/SF-Lab.git
cd SF-Lab
./gradlew build
```

To run a specific module:

```bash
./gradlew :sf-security:bootRun
```

---

## Roadmap

- [x] Spring Security
- [ ] Spring Data JPA
- [ ] Spring Data Redis
- [ ] Spring Web / REST
- [ ] Spring Batch
- [ ] Spring Cache
- [ ] Spring Events
- [ ] Spring AOP

---

## License

This project is for personal study purposes.