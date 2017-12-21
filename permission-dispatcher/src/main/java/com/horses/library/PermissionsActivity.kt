package com.horses.library

import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * @author @briansalvattore on 21/12/2017.
 */
abstract class PermissionsActivity  : AppCompatActivity() {

    @Suppress("PrivatePropertyName")
    private val NEEDED_PERMISSIONS = 2602

    private var permissionsNeed: MutableList<String> = mutableListOf()

    fun requestPermissions(vararg arrays: String) {
        permissionsNeed.clear()

        arrays.filter {
            ActivityCompat.checkSelfPermission(applicationContext, it) != PackageManager.PERMISSION_GRANTED
        }.forEach { permissionsNeed.add(it) }

        if (permissionsNeed.size > 0) {
            ActivityCompat.requestPermissions(this, permissionsNeed.toTypedArray(), NEEDED_PERMISSIONS)
        }
        else {
            permissionGranted()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == NEEDED_PERMISSIONS) {
            var success = true

            grantResults.forEach {  success = success && it == 0 }

            if (success) permissionGranted()
            else {

                val permissionsDenied: MutableList<String> = mutableListOf()

                permissionsNeed.indices.filter {
                    grantResults[it] != PackageManager.PERMISSION_GRANTED
                }.mapTo(permissionsDenied) { permissionsNeed[it] }

                permissionDenied(permissionsDenied.toTypedArray())
            }
            return
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    open fun permissionGranted() {
        Toast.makeText(applicationContext, "Permissions Granted", Toast.LENGTH_SHORT).show()
    }

    open fun permissionDenied(denied: Array<String>) {
        Toast.makeText(applicationContext, "Permissions Denied", Toast.LENGTH_SHORT).show()
    }
}