package info.codive.template.acc.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//@RunWith(AndroidJUnit4::class)
class SampleActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(SampleActivity::class.java)

    @Test
    fun message1() {
        onView(withText("message1")).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun message2() {
        onView(withText("message2")).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun message3() {
        onView(withText("message3")).check(ViewAssertions.matches(isDisplayed()))
    }
}