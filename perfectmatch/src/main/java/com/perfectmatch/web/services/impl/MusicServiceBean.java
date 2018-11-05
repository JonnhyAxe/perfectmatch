package com.perfectmatch.web.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import com.perfectmatch.persistence.model.Style;
//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfectmatch.common.persistence.services.AbstractRawService;
import com.perfectmatch.persistence.dao.ArtistRepository;
import com.perfectmatch.persistence.dao.MusicRepository;
import com.perfectmatch.persistence.model.Artist;
import com.perfectmatch.persistence.model.Music;
import com.perfectmatch.web.exception.MyBadRequestException;
import com.perfectmatch.web.exception.MyPreconditionFailedException;
import com.perfectmatch.web.services.MusicService;

/**
 * Expose web services for Music Entity
 *
 */
@Service
public class MusicServiceBean extends AbstractRawService<Music> implements MusicService {

    @Autowired
    private MusicRepository dao;
    
    @Autowired
    private ArtistRepository artistDao;

    /**
     * @return the MusicRepository
     */
    @Override
    public MusicRepository getDao() {

        return dao;
    }

    
	@Override
	public List<Music> findAll(){

        return getDao().findAll();
    }
	
    @Override
    public Music findByName(final String name) {

        return getDao().findByName(name);
    }

    @Override
    public Set<Music> findByArtist(final String name) {

        return getDao().findByArtist(name);
    }

	@Override
	public Music save(Music music) {
		//
		musicPreconditions(music);		
		Music musicByName = findByName(music.getName());
		if(Objects.nonNull(musicByName)){
			return musicByName;
		}
		return create(music);

	}
	
	@Override
	public Music updateMusic(Music music) {
		//
		musicUpdatePreconditons(music);
		Music musicToUpdate = findByName(music.getName());
		if(Objects.nonNull(musicToUpdate)) {
			merge(musicToUpdate, music);
			update(musicToUpdate);
			return musicToUpdate;
		}
		throw new MyPreconditionFailedException("Music name " + music.getName() + " does not exist");
	}
	
	//TODO: find merge method as Hibernate merge
	private void merge(Music musicToUpdate, Music music) {
		addRemixers(musicToUpdate, music);
		if(Objects.nonNull(music.getRecordLabel())) {
			musicToUpdate.setRecordLabel(music.getRecordLabel());
		}
		if(Objects.nonNull(music.getTempo())) {
			musicToUpdate.setTempo(music.getTempo());
		}
		if(Objects.nonNull(music.getKey())) {
			musicToUpdate.setKey(music.getKey());
		}
		if(Objects.nonNull(music.getEnergy())) {
			musicToUpdate.setEnergy(music.getEnergy());
		}
	}


	private void addRemixers(Music musicToUpdate, Music music) {
		Set<String> remixers = musicToUpdate.getRemixers();
		Set<String> remixersToAdd = music.getRemixers();
		if(!remixersToAdd.isEmpty()) {
			remixersToAdd.stream()
				.forEach(newRemixer -> remixers.add(newRemixer));
		}
	}


	private void musicUpdatePreconditons(Music music) {

        if (Objects.nonNull(music.getArtists()) ||
        		Objects.nonNull(music.getStyle())) {
            throw new MyBadRequestException("Some fields connot be updated");
        }
	}

	//TODO: add this to an helper class
	private void musicPreconditions(Music music) {
		if(Objects.isNull(music.getName())) {
			throw new MyPreconditionFailedException("Music name is mandatory to create musics");
		}
		if(Objects.isNull(music.getStyle())) {
			throw new MyPreconditionFailedException("Music name is mandatory to create musics");
		}else if(!Arrays.asList(Style.values()).contains(Style.valueOf(music.getStyle()))) {
			throw new MyPreconditionFailedException("Music style not found");
		}
		if(Objects.isNull(music.getArtist())) {
			throw new MyPreconditionFailedException("Artist id is mandatory to create musics");
		}		
		if(Objects.isNull(artistDao.findByName(music.getArtist()))) {
			throw new MyPreconditionFailedException("Artist Name " + music.getArtist() + " not found");
		}
	}

}
