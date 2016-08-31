# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/hrishikesh/Software/android-studio-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-keep class com.freshdesk.hotline.** { *; }
-keep class com.demach.konotor.** { *; }

# Rules to keep the FCM dependency optional
-dontwarn com.google.firebase.messaging.RemoteMessage
-keep class com.google.firebase.messaging.RemoteMessage

# Proguard config for GSON
# Ref : https://google-gson.googlecode.com/svn/trunk/examples/android-proguard-example/proguard.cfg
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# Gson specific classes
-keep class sun.misc.Unsafe { *; }

# Proguard for Calligraphy
# Keep calligraphy classes when calligraphy is included as a dependency
-keep class uk.co.chrishenx.calligraphy.** { *; }
# Ignore warning from proguard for calligraphy classes, when calligraphy is not included
-dontwarn uk.co.chrishenx.calligraphy.**

# Proguard config for AppCompat
# Ref : https://code.google.com/p/android/issues/detail?id=78293
-keep public class android.support.v7.widget.** { *; }
-keep public class android.support.v7.internal.widget.** { *; }
-keep public class android.support.v7.internal.view.menu.** { *; }

-keep public class * extends android.support.v4.view.ActionProvider {
    public <init>(android.content.Context);
}

