## Hotline Android SDK
[![Twitter](https://img.shields.io/badge/twitter-@GetHotline-orange.svg?style=flat)](https://twitter.com/GetHotline)
### [Integration Guide](http://support.hotline.io/support/solutions/folders/271861)

##### Quick Steps
Project gradle file **build.gradle**
```
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

App Module gradle file **(app/build.gradle)**
```
dependencies {
    compile 'com.github.freshdesk:hotline-android:1.0.+'
}
```

