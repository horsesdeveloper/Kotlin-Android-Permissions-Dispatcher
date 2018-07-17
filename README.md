# Kotlin-Android-Permissions-Dispa# Kotlin Android Permissions Dispatcher

It is a library to request android permissions in a simple way.

**Min SDK:** 15

## Installation
TapTargetView is distributed using jcenter
```groovy
   repositories { 
        jcenter()
   }
   
   dependencies {
         compile 'com.horses.library:permission-dispatcher:0.6'
   }
```
## Usage

### First

First you need to extend the PermissionsActivity

```kotlin
   class MainActivity : PermissionsActivity()
```

### Simple usage

You request permission like this. Simple

```kotlin
   requestPermissions(android.Manifest.permission.CAMERA)
```


### Multi permissions

If you need to request several permissions, you can do like this

```kotlin
   requestPermissions(android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
```


### Override Methods

If you need to intercept the permission response, you can do like this

```kotlin
    override fun permissionGranted() {
        Log.i(TAG , "permissionGranted")
    }

    override fun permissionDenied(denied: Array<String>) {
        Log.w(TAG , "permissionDenied " + denied.toList())
    }

    override fun permissionNeverAsk(denied: Array<String>) {
        Log.w(TAG , "permissionNeverAsk " + denied.toList())
    }
```
### Fragments
First you need to extend the PermissionsFragment
```kotlin
   class MainFragment : PermissionsFragment()
```
And the rest is the same
