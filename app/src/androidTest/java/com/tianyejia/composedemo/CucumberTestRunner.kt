package com.tianyejia.composedemo

import android.os.Bundle
import io.cucumber.android.runner.CucumberAndroidJUnitRunner
import io.cucumber.junit.CucumberOptions

@CucumberOptions(
    features = arrayOf("classpath:features"),
    glue = arrayOf("com.tianyejia.composedemo.cucumber"),
    plugin = arrayOf("pretty")
)
class CucumberTestRunner : CucumberAndroidJUnitRunner() {
    
    override fun onCreate(arguments: Bundle?) {
        super.onCreate(arguments)
    }
}