package com.tianyejia.composedemo.cucumber.steps

import io.cucumber.java.en.Given
import io.cucumber.java.en.When

class SmokeSteps {


//    I launch the application
    @Given("I launch the application")
    fun launchApplication() {
        println("✓ GIVEN: I launch the application")
    }

    @When("the main screen is displayed")
    fun mainScreenDisplayed() {
        println("✓ WHEN: the main screen is displayed")
    }

}