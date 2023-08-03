package com.musicTrack.MusicTrackDetails.controller;
import com.musicTrack.MusicTrackDetails.domain.Track;
import com.musicTrack.MusicTrackDetails.services.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TrackController {
    ITrackService iTrackService;
    @Autowired
    public TrackController(ITrackService iTrackService) {
        this.iTrackService = iTrackService;
    }

    //http://localhost:8080/api/v1/track
    @PostMapping("/track")
    public ResponseEntity<?>saveTrackDetails(@RequestBody Track track)
    {
        return new ResponseEntity<>(iTrackService.saveTrackDetails(track), HttpStatus.CREATED);
    }

    //http://localhost:8080/api/v1/tracks
    @GetMapping("/tracks")
    public ResponseEntity<?>fetchAllTrackDetails()
    {
        return new ResponseEntity<>(iTrackService.fetchAllTrackDetails(),HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/track/getById/1
    @GetMapping("/track/getById/{id}")
    public ResponseEntity<?>fetchDetailsById(@PathVariable int id)
    {
        return new ResponseEntity<>(iTrackService.fetchDetailsById(id),HttpStatus.FOUND);
    }

    //http://localhost:8080/api/v1/track/delBy/4
    @DeleteMapping("/track/delBy/{id}")
    public ResponseEntity<?>deleteTrack(@PathVariable int id)
    {
        return new ResponseEntity<>(iTrackService.deleteTrack(id),HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/track/1
    @PutMapping("/track/{id}")
    public ResponseEntity<?>updateTrackDetails(@RequestBody Track track, @PathVariable int id)
    {
        return new ResponseEntity<>(iTrackService.updateTrackDetails(track,id),HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/track/getBy/Arjit
    @GetMapping("/track/getBy/{trackArtist}")
    public ResponseEntity<?>findByTrackArtist(@PathVariable String trackArtist)
    {
        return new ResponseEntity<>(iTrackService.findByTrackArtist(trackArtist),HttpStatus.FOUND);
    }
}
