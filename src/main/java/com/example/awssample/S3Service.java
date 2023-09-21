package com.example.awssample;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S3Service {

    @Autowired
    private AmazonS3 amazonS3;


    public List<S3ObjectSummary> listObjects(String bucketName) {
        ObjectListing objectListing = amazonS3.listObjects(bucketName);
        return objectListing.getObjectSummaries();
    }

    public void deleteObject( String bucketName) {
        amazonS3.deleteObject(bucketName,"VID-20200228-WA0010.mp4");
    }
}
