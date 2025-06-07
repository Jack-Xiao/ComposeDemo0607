package com.tianyejia.composedemo

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import io.cucumber.android.runner.CucumberAndroidJUnitRunner

class CucumberTestRunner : CucumberAndroidJUnitRunner() {


    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, className, context)
    }
    override fun onCreate(arguments: Bundle?) {
        Log.d("CucumberTest", "=== CucumberTestRunner.onCreate() called ===")
        Log.d("CucumberTest", "Arguments: $arguments")
        
        try {
            // List assets to debug
            val assetManager = context.assets
            val allAssets = assetManager.list("") ?: emptyArray()
            Log.d("CucumberTest", "All assets: ${allAssets.joinToString(", ")}")
            
            val featuresAssets = assetManager.list("features") ?: emptyArray()
            Log.d("CucumberTest", "Features assets: ${featuresAssets.joinToString(", ")}")
            
        } catch (e: Exception) {
            Log.e("CucumberTest", "Failed to list assets: ${e.message}")
        }
        
        Log.d("CucumberTest", "Calling super.onCreate()...")
        super.onCreate(arguments)
        Log.d("CucumberTest", "=== CucumberTestRunner.onCreate() completed ===")
    }
}