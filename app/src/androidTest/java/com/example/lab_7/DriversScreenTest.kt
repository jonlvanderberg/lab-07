package com.example.lab_7

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_drivers_add_driver_clear_and_return_home() {
        // verify we start on home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()

        // navigate to drivers screen
        composeTestRule
            .onNodeWithTag("driveButton")
            .performClick()

        // verify drivers screen title
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // enter a driver name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Max Verstappen")

        // add the driver
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify driver appears in the list
        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertExists()

        // clear all drivers
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // verify driver has been removed from the list
        composeTestRule
            .onAllNodesWithText("Max Verstappen")
            .assertCountEquals(0)

        // return to home screen via back button
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify we're back on home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}