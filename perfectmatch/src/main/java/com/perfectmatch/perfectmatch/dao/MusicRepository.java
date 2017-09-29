package com.perfectmatch.perfectmatch.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfectmatch.perfectmatch.persistence.model.Music;

public interface MusicRepository extends JpaRepository<Music, String> {

}
