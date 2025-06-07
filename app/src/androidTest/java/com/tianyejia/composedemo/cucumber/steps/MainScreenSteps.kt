package com.tianyejia.composedemo.cucumber.steps

import android.util.Log
import io.cucumber.java.Before
import io.cucumber.java.en.But
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class MainScreenSteps {

    @Before("@ui")
    fun setup() {
        Log.e("Cucumber", "✓ SETUP: Preparing for UI tests")
        println("✓ SETUP: Preparing for UI tests")
    }

    @Given("I launch the application")
    fun launchApplication() {
        println("✓ GIVEN: I launch the application")
    }

    @When("the main screen is displayed")
    fun mainScreenDisplayed() {
        println("✓ WHEN: the main screen is displayed")
    }


    @Then("I should see {string} text")
    fun shouldSeeText(expectedText: String) {
        println("✓ THEN: I should see '$expectedText' text")
    }

    @When("I interact with the main screen")
    fun interactWithMainScreen() {
        println("✓ WHEN: I interact with the main screen")
    }

    @Then("the application should respond correctly")
    fun applicationRespondsCorrectly() {
        println("✓ THEN: the application should respond correctly")
    }
}