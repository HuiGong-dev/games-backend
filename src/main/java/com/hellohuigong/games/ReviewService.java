package com.hellohuigong.games;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;


    public Review createReview(String reviewBody, String steamId){
        Review review = reviewRepository.insert((new Review(reviewBody)));

        mongoTemplate.update(Game.class)
                .matching(Criteria.where("steamId").is(Integer.parseInt(steamId)))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }

    public Optional<Review> findReviewById(ObjectId id){
        return reviewRepository.findById(id);

    }

    public Review updateReview(Review newReview){
        return reviewRepository.save(newReview);
    }

    public ResponseEntity<HttpStatus> deleteReview(ObjectId id){
        try {
            reviewRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




}
