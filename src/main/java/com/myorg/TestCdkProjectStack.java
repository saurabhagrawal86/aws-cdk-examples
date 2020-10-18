package com.myorg;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.BucketEncryption;

public class TestCdkProjectStack extends Stack {
    public TestCdkProjectStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public TestCdkProjectStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String text = date.format(formatter);

        Bucket bucket = Bucket.Builder.create(this, "mybucketid")
                .bucketName("mycdktestbucket-" + text)
                .versioned(true)
                .encryption(BucketEncryption.KMS_MANAGED)
                .build();
    }
}
