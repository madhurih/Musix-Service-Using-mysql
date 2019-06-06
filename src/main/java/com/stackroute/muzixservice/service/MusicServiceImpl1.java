package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.Music;
import com.stackroute.muzixservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixservice.exceptions.TrackNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MusicServiceImpl1 implements MusicService
{

    @Override
    public Music saveTrack(Music music) throws TrackAlreadyExistsException {
        return null;
    }

    @Override
    public List<Music> displayTrack() throws TrackNotFoundException {
        return null;
    }

    @Override
    public Music updateTrackComments(Music music, int trackId) throws TrackNotFoundException {
        return null;
    }

    @Override
    public Music removeTrack(int trackId) throws TrackNotFoundException {
        return null;
    }

    @Override
    public Music trackByName(String trackName) throws TrackNotFoundException {
        return null;
    }
}
