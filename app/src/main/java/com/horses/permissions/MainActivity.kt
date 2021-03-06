package com.horses.permissions

import android.os.Build
import android.os.Bundle
import android.util.Log
import com.horses.library.PermissionsActivity

class MainActivity : PermissionsActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //supportFragmentManager.beginTransaction().replace(R.id.content, MainFragment()).commit()
    }

    override fun onResume() {
        super.onResume()


        requestPermissions(android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    override fun permissionGranted() {
        super.permissionGranted()
        Log.i(TAG , "permissionGranted")
    }

    override fun permissionDenied(denied: Array<String>) {
        super.permissionDenied(denied)
        Log.w(TAG , "permissionDenied " + denied.toList())

        requestPermissions(*denied)
    }

    override fun permissionNeverAsk(denied: Array<String>) {
        super.permissionNeverAsk(denied)
        Log.w(TAG , "permissionNeverAsk " + denied.toList())

    }
}
