````markdown
# Talent Matcher – Full Stack Web App

## 🛠️ Tech Stack

- **Backend**: Java 17, Spring Boot, PostgreSQL
- **Frontend**: Vue 3 with Vuetify UI framework
- **Containerization**: Docker & Docker Compose

---

## 🚀 Setup Instructions

This repository contains both the backend and frontend code for the Talent Matcher web application.

### Prerequisites

- [Docker](https://www.docker.com/) must be installed on your machine.

### Getting Started

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/talent-matcher.git
   cd talent-matcher
````
2. **Build the Back end side
   ```bash
   cd matchmaker
   ./gradlew.bat build
   ```
   This will generate the .jar that will be consumed through our docker compose file to launch the web app

3. **Run the full stack application:**

   ```bash
   docker-compose up --build
   ```

4. **Access the app:**

   * **Frontend**: [http://localhost:3000](http://localhost:3000)
   * **Backend API**: [http://localhost:8080](http://localhost:8080)

All services should start automatically via Docker Compose.

---

## 💭 Personal Reflection

This project was a great opportunity to revisit and apply several technologies. While setting up the backend and Docker integration came naturally, I realized that my Vue.js knowledge had gotten a bit rusty.

Working on the frontend took more time than expected. I had to revisit old courses and spend quite a bit of time searching through documentation and examples. That part was a little frustrating, and I'm not fully satisfied with the final client implementation. If I were evaluating it myself, I'd consider it below the standard I’d want to submit.

On the other hand, the Docker integration was something I was excited to tackle — and I’m proud to say I got it working smoothly.

Additionally, while setting up the Java backend, I kept finding new things I could improve or add. It quickly turned into a bit of an "infinite loop," where I struggled to decide where to stop and draw the line for the scope of this assessment.
### 📚 What I Learned

* Brushed up on Vue 3 and Vuetify
* Deepened my understanding of Docker and Compose setups
* Identified areas for improvement — especially in frontend development

Despite the challenges, I genuinely enjoyed the process and appreciated the insights it gave me into my strengths and weaknesses.
