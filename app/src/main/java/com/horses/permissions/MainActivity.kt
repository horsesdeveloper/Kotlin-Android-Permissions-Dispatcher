package com.horses.permissions

import android.os.Bundle
import android.util.Log
import com.horses.library.PermissionsActivity

class MainActivity : PermissionsActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermissions(android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    override fun permissionGranted() {
        super.permissionGranted()
        Log.i(TAG , "permissionGranted")
    }

    override fun permissionDenied(denied: Array<String>) {
        super.permissionDenied(denied)
        Log.w(TAG , "permissionDenied " + denied.toList())
    }
}
