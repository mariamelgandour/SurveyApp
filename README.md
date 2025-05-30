Android Survey App

An Android application built using Java and SQLite that allows users to participate in a one-time survey. The app manages users, loads questions from a local database, and stores responses for future reference.

---

## 🚀 Features

- Allows users to enter their name to start the survey.
- Prevents duplicate participation using a name check.
- Displays a toast message if the user has already taken the survey.
- Loads survey questions from a local SQLite database.
- Saves user names and responses into the database.
- Offers a menu to:
  - View the number of participants.
  - List all users.
  - View detailed answers for each user.

---

## 🛠️ Technologies Used

- Java
- Android SDK
- SQLite (local database)
- Intents (for screen navigation)
- Toasts (for user notifications)
- ListView and Adapters (for dynamic data display)
- Menu system (for navigating app features)

---

## 🧪 How It Works

1. The user enters their name to begin.
2. The app checks if the name is already in the database.
   - If not, the survey starts.
   - If yes, the app prevents duplicate entry.
3. Survey questions are loaded from SQLite.
4. User responses are saved with their name.
5. Admin features (via menu) allow viewing:
   - Total users
   - List of participants
   - Detailed responses per user

---

## 📌 Notes

- Data is stored locally; no internet connection is required.
- This app is intended for offline surveys or demos.
- It ensures that each user can participate only once.
 
 
