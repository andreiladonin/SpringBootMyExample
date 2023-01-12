package ru.springladonin.musicweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springladonin.musicweb.entities.Track;
import ru.springladonin.musicweb.repositories.TrackRepository;

import java.util.List;

@Service
public class TrackService
{

    private TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    public List<Track> getAllTracks(){
        return trackRepository.findAll();
    }

    public Track getTrackById(Long id) {
        return trackRepository.findById(id).get();
    }

    public void  deleteTrackById(Long id) {
        trackRepository.deleteById(id);

    }

    public void addTrack(Track track) {
        trackRepository.save(track);
    }
}
