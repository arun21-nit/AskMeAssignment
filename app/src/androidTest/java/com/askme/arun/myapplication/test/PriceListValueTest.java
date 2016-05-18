package com.askme.arun.myapplication.test;


import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;

import com.askme.arun.myapplication.view.MainActivity;

/**
 * Created by Arun on 18/5/16.
 */
public class PriceListValueTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity mActivity;

    public PriceListValueTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
    }

    @SmallTest
    public void connectedToInternet() {
        assertTrue(mActivity.isNetworkAvailable());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}