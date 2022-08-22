# AdmobSdkAfTech
[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=21)
[![](https://jitpack.io/v/adnanamin69/AdmobSdkAfTech.svg)](https://jitpack.io/#adnanamin69/AdmobSdkAfTech)


## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		....
		maven { url "https://jitpack.io" }
		....
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):


```gradle
dependencies {
....
  implementation 'com.github.adnanamin69:AdmobSdkAfTech:0.6'
....
}
```

##  Manifest 
Add admob app id in your `Manifest` file :
```manifest 
   <meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="@string/admob_app_id" />
```
#### or
```
   <meta-data
            android:name="com.google.android.gms.ads.AD_MANAGER_APP"
            android:value="true" />
```

##  AppOpenAd
For app open ad create `MyApp` class Extend from `MyBaseApplication`  Class : 

override a method `getOpenId()` and return App open Id 


### Kotlin
```kotlin 
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

```java
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
##  Interstitial Ad
For Interstitial  Extend you activity  from `BaseActivity`  Class : 

override a method `getInterstitialId1()` and return your Interstitial Id 

set elapse time for Interstitial once the ad shows then the ad will not be showing for the elepse time in seconds. 

default elapse time is 15 sconds 

call function `showFullAd{}` to show Interstitial

### Kotlin
```kotlin
  class MainActivity : BaseActivity() {
    override fun getInterstitialId1(): String {
        return getString(R.string.app_interstitial_id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  elapseTime = 20 
      //by default its 15 seconds 
    }

    fun onclick() {
        showFullAd {
	//do your futher work 
        //this block will execute on add dissmiss , ad is null or fail to load add
        showToastShort("after ad")
        }

    }
}
```
#### show full ad 
```kotlin
 showFullAd {
	//do your futher work 
        //this block will execute on add dissmiss , ad is null or fail to load add
        showToastShort("after ad")
        }
```
#### chage elapse time 
```diff
 elapseTime = 20 
 ```

### Java
```java
  public class JavaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        setElapseTime(20);
      //by default its 15 seconds 
        showFullAd(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                 //do your further work 
                //this block will execute on add dissmiss , ad is null or fail to load add
                showToastShort("after ad");
                return Unit.INSTANCE;
            }
        });
    }

    @NonNull
    @Override
    public String getInterstitialId1() {
        return getString(R.string.app_interstitial_id);
    }
}
```
#### show full ad 
```java
  showFullAd(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                 //do your further work 
                //this block will execute on add dissmiss , ad is null or fail to load add
                showToastShort("after ad");
                return Unit.INSTANCE;
            }
        });
```
#### chage elapse time 
```diff
  setElapseTime(20);
 ```
 
 ## Firebase Analytics
 For posting simple firebase `Analytics` from `Activity`  Extend you activity  from `BaseActivity`  Class and `Fragment` from `BaseFragment` : 
 
 call a fuction `postAnalytic("event")` and pass your `event`  in parameter

```diff
  postAnalytic("event);
 ```

 ## Contributing

Please fork this repository and contribute back using
[pull requests](https://github.com/adnanamin69/AdmobSdkAfTech/pulls).

Any contributions, large or small, major features, bug fixes, are welcomed and appreciated
but will be thoroughly reviewed .

### Contact - Let's become friend
- [Twitter](https://twitter.com/amin69_a)
- [Github](https://github.com/adnanamin69)
- [Linkedin](https://www.linkedin.com/in/adnanamin69/)
- [Facebook](https://www.facebook.com/adnanamin69)


## MIT License

### Copyright (c) 2022 Adnan Amin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
