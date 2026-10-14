package com.alexandregomez;

import software.amazon.awscdk.App;
import software.amazon.awscdk.AppProps;

public class CursoAwsCdkApp {
    public static void main(String[] args) {
        App app = new App();

        new VpcStack(app, "Vpc");

        app.synth();
    }
}