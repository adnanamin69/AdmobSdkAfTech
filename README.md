# AdmobSdkAfTech
[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=21)
[![](https://jitpack.io/v/adnanamin69/AdmobSdkAfTech.svg)](https://jitpack.io/#adnanamin69/AdmobSdkAfTech)


## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
....
  implementation 'com.github.adnanamin69:AdmobSdkAfTech:0.5'
....
}
```

##  Manifest 
Add admob app id in your `Manifest` file :
```
   <meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="@string/admob_app_id" />
```


##  AppOpenAd
For app open ad create `MyApp` class Extend from `MyBaseApplication`  Class : 

override a method `getOpenId()` and return App open Id 


### Kotlin
```
   class MyApp : MyBaseApplication() {

    override fun getOpenId(): String {
        return getString(R.string.app_open_id)
    }

    override fun onCreate() {
        super.onCreate()

    }
}
```

### Java

```
public class MyAppLication extends MyBaseApplication {
    @NonNull
    @Override
    public String getOpenId() {
        return getString(R.string.app_open_id);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        
    }
}
```



