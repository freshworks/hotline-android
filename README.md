## Hotline Android SDK

### [Integration Guide](https://hotline.freshdesk.com/support/solutions/articles/9000037054-hotline-android-sdk-integration-steps)

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
    compile 'com.github.freshdesk:hotline-android:v1.0.0'
}
```

