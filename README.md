## Hotline Android SDK - [![Release](https://jitpack.io/v/freshdesk/hotline-android.svg)](https://jitpack.io/#freshdesk/hotline-android)

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

App Module gradle file **(app/build.gradle)** [![GitHub version](https://badge.fury.io/gh/freshdesk%2Fhotline-android.svg)](https://badge.fury.io/gh/freshdesk%2Fhotline-android)
```
dependencies {
    compile 'com.github.freshdesk:hotline-android:{latestVersion}'
}
```

