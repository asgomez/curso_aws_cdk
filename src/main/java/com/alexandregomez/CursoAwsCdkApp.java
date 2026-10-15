
package com.alexandregomez;

import software.amazon.awscdk.App;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.Environment;

public class CursoAwsCdkApp {
    public static void main(String[] args) {
        App app = new App();

        Environment environment = Environment.builder()
                .account("852138521129")
                .region("sa-east-1")
                .build();

        VpcStack vpcStack = new VpcStack(
                app, "Vpc", StackProps.builder().env(environment).build());

        ClusterStack clusterStack = new ClusterStack(
                app,
                "Cluster",
                StackProps.builder().env(environment).build(),
                vpcStack.getVpc());

        clusterStack.addStackDependency(vpcStack);

        app.synth();
    }
}
