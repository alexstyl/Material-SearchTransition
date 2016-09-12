package com.alexstyl.searchtransition.boilerplate;

import android.app.Activity;
import android.content.Intent;

import java.util.Locale;

public class ShareDemo {

    private static final String NAME = "Material-SearchTransition";
    private static final String URL = "https://github.com/alexstyl/" + NAME;

    private final Activity activity;

    public ShareDemo(Activity activity) {
        this.activity = activity;
    }

    public void shareDemo() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Checkout this demo");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, String.format(Locale.US, "Checkout %s at %s", NAME, URL));
        activity.startActivity(Intent.createChooser(sharingIntent, "Share demo via..."));

    }
}
