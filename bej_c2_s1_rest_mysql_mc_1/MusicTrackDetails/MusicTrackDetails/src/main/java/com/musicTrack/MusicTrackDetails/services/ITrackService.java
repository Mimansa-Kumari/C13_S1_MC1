package com.musicTrack.MusicTrackDetails.services;

import com.musicTrack.MusicTrackDetails.domain.Track;

import java.util.List;

public interface ITrackService {
    Track saveTrackDetails(Track track);
    List<Track> fetchAllTrackDetails();
    Track fetchDetailsById(int id);
    boolean deleteTrack(int id);
    Track updateTrackDetails(Track track, int id);
    List<Track>findByTrackArtist(String trackArtist);
}
