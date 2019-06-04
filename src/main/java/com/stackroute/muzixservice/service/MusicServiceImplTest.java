package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.Music;
import com.stackroute.muzixservice.exceptions.TrackNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MusicServiceImplTest implements MusicService
{

    @Override
    public Music saveTrack(Music music) {
        return null;
    }

    @Override
    public List<Music> displayTrack() {
        return null;
    }

    @Override
    public Music updateTrackComments(Music music, int trackId) throws TrackNotFoundException {
        return null;
    }

    @Override
    public void removeTrack(int trackId) {

    }

    @Override
    public Music trackByName(String trackName) {
        return null;
    }
}
