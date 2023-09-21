package com.example.awssample;

import com.amazonaws.services.s3.model.S3ObjectSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class AwsSampleApplication {
    @Autowired
    public S3Service s3Service;

	@GetMapping("/read")
	public void read() {
		List<S3ObjectSummary> s3ObjectSummaries = s3Service.listObjects("sample-01234");
		for (S3ObjectSummary item:
			 s3ObjectSummaries) {
			System.out.println(item.toString());
		}
	}

	@DeleteMapping("/bucket/{bucketname}")
	public void delete(@PathVariable  String bucketname) {
		s3Service.deleteObject(bucketname);
	}

	public void readS3() {

	}
	public static void main(String[] args) {
		SpringApplication.run(AwsSampleApplication.class, args);
	}

}
