package com.musicTrack.MusicTrackDetails.repository;

import com.musicTrack.MusicTrackDetails.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITrackRepository extends JpaRepository<Track,Integer> {
    List<Track> findByTrackArtist(String trackArtist);
}
