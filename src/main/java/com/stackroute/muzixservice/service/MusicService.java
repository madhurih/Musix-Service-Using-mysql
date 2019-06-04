package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.Music;
import com.stackroute.muzixservice.exceptions.TrackNotFoundException;
import java.util.List;

public interface MusicService
{
    public Music saveTrack(Music music);
    public List<Music>displayTrack();
    //public Music displayTracksById(int id);
    public Music updateTrackComments(Music music, int trackId) throws TrackNotFoundException;
    public void removeTrack(int trackId);
    public Music trackByName(String trackName);
}