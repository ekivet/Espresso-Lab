package ly.generalassemb.espresso;

import android.app.Application;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import dalvik.annotation.TestTargetClass;

/**
 * Created by erickivet on 7/21/16.
 */

@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    @Rule
    public ActivityTestRule<BalanceActivity>mActivityTestRule =
            new ActivityTestRule<>(BalanceActivity.class);

    @Test
    public void testBalance() throws Exception{
        onView(withId(R.id.balanceTextView)).check(matches(isDisplayed()));
    }

    @Test
    public void testWithdrawl() throws Exception{
        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("cheap wine"),closeSoftKeyboard());
        onView(withId(R.id.amountEditText)).perform(typeText("4.46"),closeSoftKeyboard());
        onView(withId(R.id.withdrawButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("-$4.46")));
    }

    @Test
    public void testDeposit() throws Exception{
        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("sold kidney"),closeSoftKeyboard());
        onView(withId(R.id.amountEditText)).perform(typeText("350.00"),closeSoftKeyboard());
        onView(withId(R.id.depositButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("$350.00")));
    }

    @Test
    public void testMultiple() throws Exception{
        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("pawned iphone"),closeSoftKeyboard());
        onView(withId(R.id.amountEditText)).perform(typeText("80.00"),closeSoftKeyboard());
        onView(withId(R.id.depositButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("$80.00")));

        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("walmart"),closeSoftKeyboard());
        onView(withId(R.id.amountEditText)).perform(typeText("56.00"),closeSoftKeyboard());
        onView(withId(R.id.withdrawButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("$24.00")));

        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("overdraft at atm")
                ,closeSoftKeyboard());
        onView(withId(R.id.amountEditText)).perform(typeText("100.00"),closeSoftKeyboard());
        onView(withId(R.id.withdrawButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("-$76.00")));

        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("overdraft fee")
                ,closeSoftKeyboard());
        onView(withId(R.id.amountEditText)).perform(typeText("20.00"),closeSoftKeyboard());
        onView(withId(R.id.withdrawButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("-$96.00")));

        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("sold gold tooth")
                ,closeSoftKeyboard());
        onView(withId(R.id.amountEditText)).perform(typeText("120.00"),closeSoftKeyboard());
        onView(withId(R.id.depositButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("$24.00")));
    }







}
