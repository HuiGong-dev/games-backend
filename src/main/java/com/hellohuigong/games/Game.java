package com.hellohuigong.games;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "games")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    private ObjectId id;
    private String name;
    private String steam_appid;
    private String header_image;
    private List<String> genres;
    private List<String> screenshots;
    private List<String> movies;
    private String release_date;
    private  String background;
    private String background_raw;
    @DocumentReference
    private List<Review> reviewIds;



}
