package com.perfectmatch.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.perfectmatch.persistence.dao.MusicRepository;
import com.perfectmatch.persistence.model.Music;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicRepository musicJpaRepository;

    @RequestMapping(path = "/repo", method = RequestMethod.GET)
    public Iterable<Music> findByRepo() throws IOException {

        return musicJpaRepository.findAll();
    }

}
