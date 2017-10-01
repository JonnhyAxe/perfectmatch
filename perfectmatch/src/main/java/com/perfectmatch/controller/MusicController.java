package com.perfectmatch.controller;


import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.perfectmatch.persistence.dao.MusicRepository;
import com.perfectmatch.persistence.model.Music;
import com.perfectmatch.web.exception.MyBadRequestException;


/*
 * Controller of the Music Entity
 */


@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicRepository musicJpaRepository;

    @RequestMapping(path = "/repo", method = RequestMethod.GET)
    public Iterable<Music> findByRepo() throws IOException {

        return musicJpaRepository.findAll();
    }

    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public Music findByName(@PathVariable("name")
    @Valid
    final String musicName) throws IOException {

        return musicJpaRepository.findByName(musicName);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody
    @Valid
    final Music resource) {

        if (resource.getArtist() == null) {
            throw new MyBadRequestException("Artist must not be null");
        }
        musicJpaRepository.save(resource);
    }

}
