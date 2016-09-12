package com.alexstyl.searchtransition.transition;

import android.transition.AutoTransition;
import android.transition.Transition;

public class FadeInTransition extends AutoTransition {

    private static final int FADE_IN_DURATION = 200;

    private FadeInTransition() {
        // force callers to call the factory method to instantiate this class
    }

    public static Transition createTransition() {
        AutoTransition transition = new AutoTransition();
        transition.setDuration(FADE_IN_DURATION);
        return transition;
    }
}
