﻿# JetFeatureX

JetFeatureX is a modern Android application built using **Jetpack Compose** and follows a clean architecture pattern. This project serves as a learning playground to implement various Android development concepts, including state management, navigation, animations, and backend API integration.

The goal of this project is to provide a modular, scalable, and extensible base for Android applications while showcasing modern development practices.

---

## 🚀 Features

- **Jetpack Compose:** Fully Compose-based UI.
- **MVVM Architecture:** Separation of concerns with ViewModel.
- **Navigation Component:** Seamless navigation between screens.
- **Hilt:** Dependency injection made simple.
- **Retrofit:** For making RESTful API calls.
- **Room:** Local database integration.
- **Material 3 Design:** Modern UI components and theming.
- **Animations:** Dynamic user interactions with Compose animation APIs.
- **Modular Structure:** Clean and organized project structure.

---

## 📂 Directory Structure

Here’s the project’s modular and scalable directory structure:

```plaintext
src/main/java/com/yourname/jetfeaturex/
├── data/                           # Data Layer
│   ├── model/                      # Data Models (Room Entities, DTOs)
│   ├── local/                      # Room Database and DAO
│   ├── remote/                     # Retrofit Services
│   └── repository/                 # Data Sources (Local + Remote)
│
├── di/                             # Dependency Injection (Hilt Modules)
│
├── ui/                             # User Interface Layer
│   ├── components/                 # Reusable UI Components
│   ├── screens/                    # Screen Composables (Login, Home, etc.)
│   ├── navigation/                 # Navigation Graphs
│   └── theme/                      # App Theming (Colors, Typography)
│
├── utils/                          # Utility Classes and Helpers
│
├── viewmodel/                      # ViewModel Layer
│
├── MainActivity.kt                 # Entry Point of the Application
└── App.kt                          # Application Class with Hilt
```

---

## 🛠️ Built With

This project leverages the following technologies and tools:

- **Kotlin:** The primary programming language.
- **Jetpack Compose:** Modern UI toolkit for building native UI.
- **Hilt:** Simplified dependency injection for Android.
- **Retrofit:** Type-safe HTTP client for making API calls.
- **Room:** Persistence library for local database.
- **Navigation Component:** Compose-based navigation.
- **Material 3:** Modern material design components.

---

## 🛠️ How to Run

To run this project on your local machine:

1. Clone the repository:
   ```bash
   git clone https://github.com/MehdiALOMER/JetFeatureX.git
   ```
2. Open the project in **Android Studio**.
3. Ensure you have the latest **Android Studio Flamingo** version or higher.
4. Sync Gradle files.
5. Run the app on an emulator or a physical device.

---

## 📖 Learning Objectives

This project demonstrates:

- How to structure an Android application for scalability.
- Best practices for implementing MVVM architecture.
- State management using Compose.
- The use of animations to enhance user experience.
- Integration of RESTful APIs with Retrofit.
- Local data storage using Room.
- Dependency injection with Hilt.
- Theming with Material 3.

---

## 📷 Screenshots

Screenshots of the app will be added soon!

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🤝 Contributions

Contributions are welcome! If you’d like to improve this project, please open a pull request.

---

## 💡 Future Enhancements

- Add API integration for dynamic data.
- Implement advanced animations.
- Add unit and UI tests.
- Integrate push notifications.
- Build additional screens and features.
