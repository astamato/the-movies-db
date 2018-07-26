The Movies DB
======

Mobile app to help people discover the current most popular movies and find more information about movies their friends are talking about.
The app consists of a homepage displaying the most popular movies, a search bar to search for movies by name an additional details
 screen when choosing any movie.

### Install
1) Clone the repository.

2)
The code can be checked out and deployed to all:
* Native emulator
* Genymotion emulator
* real device

A- Running from Android Studio IDE.


Build -> Clean
Build -> Make project
Run -> Run

B- Running the app through the console:

```
$ ./gradlew clean assembleDebug installDebug
$ adb shell am start -n "com.jet.alejandrastamato.themoviesdb/com.jet.alejandrastamato.themoviesdb.list.MovieListActivity" -a
android.intent.action.MAIN -c android.intent.category.LAUNCHER
```

### Technical generalities

Developed in Kotlin
Following architecture MVP with rx binding.

Using different 3rd party libraries:
- DI: Dagger 2
- Networking: Okhttp/Retrofit
- DB: Android's Room
