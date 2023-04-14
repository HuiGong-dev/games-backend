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
    private Integer steamId;
    private String header;
    private List<String> genres;
    private List<String> screenshots;
    private List<String> movies;
    private String releaseDate;
    private  String background;
    private String backgroundRaw;
    @DocumentReference
    private List<Review> reviewIds;



}
