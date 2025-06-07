package com.tianyejia.composedemo.cucumber.steps

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tianyejia.composedemo.MainActivity
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainScreenSteps {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Given("I launch the application")
    fun launchApplication() {
        // Activity is automatically launched by composeTestRule
        Thread.sleep(1000) // Allow UI to settle
    }

    @When("the main screen is displayed")
    fun mainScreenDisplayed() {
        // Verify main screen is displayed by checking text exists
        composeTestRule.onNodeWithText("Hello Android!")
            .assertIsDisplayed()
    }

    @Then("I should see {string} text")
    fun shouldSeeText(expectedText: String) {
        // Verify text is displayed using Compose Test
        composeTestRule.onNodeWithText(expectedText)
            .assertIsDisplayed()
    }

    @When("I interact with the main screen")
    fun interactWithMainScreen() {
        // Basic interaction - verify text is clickable/visible
        composeTestRule.onNodeWithText("Hello Android!")
            .assertIsDisplayed()
    }

    @Then("the application should respond correctly")
    fun applicationRespondsCorrectly() {
        // Verify application response - text should still be visible
        composeTestRule.onNodeWithText("Hello Android!")
            .assertIsDisplayed()
    }
}