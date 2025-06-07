package com.tianyejia.composedemo.cucumber.hooks

import android.util.Log
import io.cucumber.java.After
import io.cucumber.java.Before

class TestHooks {
    
    companion object {
        private const val TAG = "CucumberTestHooks"
    }

    @Before
    fun beforeScenario() {
        Log.d(TAG, "Starting scenario")
    }

    @After
    fun afterScenario() {
        Log.d(TAG, "Scenario completed")
    }
}