package com.perfectmatch.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfectmatch.persistence.model.Music;

public interface MusicRepository extends JpaRepository<Music, String> {

}
