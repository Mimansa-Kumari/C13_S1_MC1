package com.musicTrack.MusicTrackDetails.services;

import com.musicTrack.MusicTrackDetails.domain.Track;
import com.musicTrack.MusicTrackDetails.repository.ITrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements ITrackService{
    ITrackRepository iTrackRepository;
    @Autowired
    public TrackServiceImpl(ITrackRepository iTrackRepository) {
        this.iTrackRepository = iTrackRepository;
    }

    @Override
    public Track saveTrackDetails(Track track) {
        return iTrackRepository.save(track);
    }

    @Override
    public List<Track> fetchAllTrackDetails() {
        return iTrackRepository.findAll();
    }

    @Override
    public Track fetchDetailsById(int id) {
        return iTrackRepository.findById(id).get();
    }

    @Override
    public boolean deleteTrack(int id) {
        iTrackRepository.deleteById(id);
        return true;
    }

    @Override
    public Track updateTrackDetails(Track track, int id) {
        Optional<Track> track1 = iTrackRepository.findById(id);
        if(track1.isEmpty())
        {
            return null;
        }
        Track existingTrack = track1.get();
        if(track.getTrackName()!=null)
        {
            existingTrack.setTrackName(track.getTrackName());
        }
        if(track.getTrackArtist()!=null)
        {
            existingTrack.setTrackArtist(track.getTrackArtist());
        }
        if(track.getTrackComment()!=null)
        {
            existingTrack.setTrackComment(track.getTrackComment());
        }
        if(track.getTrackRating()!=null)
        {
            existingTrack.setTrackRating(track.getTrackRating());
        }
        return existingTrack;
    }

    @Override
    public List<Track> findByTrackArtist(String trackArtist) {
        return iTrackRepository.findByTrackArtist(trackArtist);
    }
}
