package com.myorg;

import software.amazon.awscdk.core.App;

import java.util.Arrays;

public class TestCdkProjectApp {
    public static void main(final String[] args) {
        App app = new App();

        new TestCdkProjectStack(app, "TestCdkProjectStack");

        app.synth();
    }
}
