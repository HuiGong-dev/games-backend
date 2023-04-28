package com.hellohuigong.games;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("steamId")), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable ObjectId id, @RequestBody Map<String, String> payload){
        Optional<Review> reviewData = reviewService.findReviewById(id);
        if(reviewData.isPresent()){
            Review _review = reviewData.get();
            _review.setBody(payload.get("reviewBody"));
            return new ResponseEntity<Review>(reviewService.updateReview(_review), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable ObjectId id){
        return reviewService.deleteReview(id);
    }

}
