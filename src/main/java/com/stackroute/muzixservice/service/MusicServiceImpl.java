package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.Music;
import com.stackroute.muzixservice.exceptions.TrackNotFoundException;
import com.stackroute.muzixservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.List;

@CacheConfig(cacheNames = "music")
@Component
@Service
@Primary
public class MusicServiceImpl implements MusicService
{
    MusicRepository musicRepository;

    public void simulateDelay() {
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public Music saveTrack(Music music)
    {
        Music savedTrack = musicRepository.save(music);
        return savedTrack;
    }

    @Override
    @Cacheable
    public List<Music> displayTrack() {
        return musicRepository.findAll();
    }

//    @Override
//    public Music displayTracksById(int id) {
//        return musicRepository.findById(id).get();
//    }

    @Override
    @CachePut
    public Music updateTrackComments(Music music, int id)throws TrackNotFoundException {
        if(!musicRepository.existsById(music.getId()))
        {
            throw new TrackNotFoundException("User Not Found");
        }
        Music musicList = musicRepository.findById(id).get();
        musicList.setTrackComments(music.getTrackComments());
        return musicList;
    }

    @Override
    public void removeTrack(int trackId) {
        musicRepository.deleteById(trackId);
    }

    @Override
    public Music trackByName(String trackName) {
        return musicRepository.trackByName(trackName);
    }

    @PostConstruct
    public void loadData()
    {
        musicRepository.save(Music.builder().id(4).trackName("Unse mili najar").trackComments("sweet song").build());
        musicRepository.save(Music.builder().id(5).trackName("senorita maria").trackComments("love song").build());
    }
}