package com.musicTrack.MusicTrackDetails.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Track {
    @Id
    int trackId;
    String trackName;
    String trackComment;
    String trackRating;
    String trackArtist;

}
