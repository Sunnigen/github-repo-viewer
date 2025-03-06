# GitHub Repository Viewer

## 📌 Overview
GitHub Repository Viewer is an Android app that fetches and displays a list of GitHub repositories using the GitHub API. Users can browse repositories sorted by newest or most popular and view details such as repository name, owner, stars, and programming language.

![Demo](images/2025-03-06%2014.20.14.gif)

## 🎯 Features
- Fetches repositories using **GitHub API**
- Displays repositories in a **RecyclerView**
- Shows **repository name, owner, star count, and language**
- Loads **profile images using Glide**
- Handles **API errors and network failures**
- Implements **MVVM architecture** for separation of concerns

## 🛠 Tech Stack
- **Kotlin** - Primary programming language
- **Retrofit** - API calls and network management
- **Gson** - JSON parsing
- **RecyclerView** - Displaying repository lists
- **Glide** - Image loading for repository avatars
- **ViewModel + LiveData** - Managing UI state and data

## 🚀 Project Setup
### 1️⃣ Clone the Repository
```sh
git clone https://github.com/yourusername/github-repo-viewer.git
cd github-repo-viewer
```

### 2️⃣ Add Required Dependencies
Ensure the following dependencies are in your `build.gradle (Module: app)` file:
```gradle
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'com.github.bumptech.glide:glide:4.12.0'
annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2'
implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.6.2'
implementation 'androidx.recyclerview:recyclerview:1.2.1'
```

### 3️⃣ Add Internet Permission
Add the following line to `AndroidManifest.xml`:
```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

### 4️⃣ Run the App
- Open the project in **Android Studio**
- Click **Run ▶** to launch the app

## 📌 Architecture
This project follows the **MVVM (Model-View-ViewModel)** pattern:

```
📂 data/
 ├── api/              # Retrofit API service
 ├── model/            # Data models
 ├── repository/       # Handles API calls
📂 ui/
 ├── adapter/          # RecyclerView adapter
 ├── viewmodel/        # ViewModel for UI state management
📂 res/layout/
 ├── activity_main.xml # Main UI layout
 ├── repo_item.xml     # UI for each repo item
```

## 🔄 API Usage
The app queries the **GitHub Search API**:
```
GET https://api.github.com/search/repositories?q=stars:>0&sort=created&order=desc&per_page=20&page=1
```

### **Handling API Errors**
- **422 Unprocessable Entity** → Ensure query format is correct.
- **403 Forbidden** → GitHub rate limit exceeded, use authentication.
- **No Internet** → Display error message.

## 🌟 Future Enhancements
- 🔍 **Search functionality** for user-defined queries
- 🔄 **Swipe-to-refresh** feature
- 📜 **Pagination** for infinite scrolling
- 🛜 **Offline caching** with Room Database

## 📝 License
This project is licensed under the MIT License.

---

💡 **Contributions are welcome!** Feel free to fork the repository and submit pull requests. Happy coding! 🚀

