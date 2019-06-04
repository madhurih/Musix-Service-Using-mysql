package com.stackroute.muzixservice.repository;

import com.stackroute.muzixservice.domain.Music;
//import org.h2.command.dml.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer>
{
    @Query("select m from Music m where m.trackName=:trackName")
    public Music trackByName(@Param("trackName")String trackName);
}