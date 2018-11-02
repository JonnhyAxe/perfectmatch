package com.perfectmatch.persistence.setup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.perfectmatch.persistence.model.Match;
import com.perfectmatch.persistence.model.Music;
import com.perfectmatch.persistence.model.Sample;
import com.perfectmatch.persistence.model.Style;
import com.perfectmatch.web.services.MusicService;
import com.perfectmatch.web.services.SampleMatchService;
import com.perfectmatch.web.services.SampleService;

/**
 * This simple setup class will run during the bootstrap process of Spring and
 * will create some setup data <br>
 * The main focus here is creating some Music artist, Samples and Samples'
 * matches
 */
@Component
@Profile("dev")
public class PerfectMatchSetup implements ApplicationListener<ContextRefreshedEvent> {

    // Only for setup purposes
    private boolean setupDone;

    @Autowired
    private MusicService musicService;


    @Autowired
    private SampleService sampleService;

    @Autowired
    private SampleMatchService sampleMatchService;

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.context.ApplicationListener#onApplicationEvent(org.
     * springframework.context.ApplicationEvent)
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {

        if (!setupDone) {
        	getMusicServiceBean().deleteAll();
        	getSampleServiceBean().deleteAll();
        	getSampleMatchServiceBean().deleteAll();
            createMusic();
        }

    }


    /**
     * Create Music data in the DB
     */
    private void createMusic() {

    	
        Music musicPleaseStop = new Music();
        musicPleaseStop.setArtist("Latmun");
        musicPleaseStop.setName("Please Stop (Original Mix)");
        musicPleaseStop.setStyle(Style.TECH_HOUSE.name());

        Sample samplePleaseStop = new Sample();
        samplePleaseStop.setTimestamp(3 * 60); // Start time stamp at 00:03:00m
        samplePleaseStop.setName(musicPleaseStop.getArtist() + ":" + musicPleaseStop.getName());

        musicPleaseStop.setSamples(new HashSet<Sample>(Arrays.asList(samplePleaseStop)));

        Music musicDef = new Music();
        musicDef.setArtist("Latmun");
        musicDef.setName("def (Original Mix)");
        musicDef.setStyle(Style.TECH_HOUSE.name());

        Sample sampleDef = new Sample();
        sampleDef.setTimestamp(3 * 60); // Start time stamp at 00:03:00m
        sampleDef.setName(musicDef.getArtist() + ":" + musicDef.getName());

        musicDef.setSamples(new HashSet<Sample>(Arrays.asList(sampleDef)));


        Match newMatch = new Match();
        newMatch.setName(samplePleaseStop.getName());
        newMatch.setSampleFromRule(sampleDef.getName());
        newMatch.setRule("BY_SAME_ARTIST_NAME");

        samplePleaseStop.setMathes(new HashSet<Match>(Arrays.asList(newMatch)));

        if (Objects.isNull(getSampleMatchServiceBean().findByName(newMatch.getName()))) {
            getSampleMatchServiceBean().create(newMatch);
        }

        if (Objects.isNull(getSampleServiceBean().findByName(samplePleaseStop.getName()))) {
            getSampleServiceBean().create(samplePleaseStop);
        }

        if (Objects.isNull(getSampleServiceBean().findByName(sampleDef.getName()))) {
            getSampleServiceBean().create(sampleDef);
        }

        if (Objects.isNull(getMusicServiceBean().findByName(musicPleaseStop.getName()))) {
            getMusicServiceBean().create(musicPleaseStop);
        }

        if (Objects.isNull(getMusicServiceBean().findByName(musicDef.getName()))) {
            getMusicServiceBean().create(musicDef);
        }

        // Test insert music without samples and Match

        Music music = new Music();
        music.setArtist("LatmunXPTO");
        music.setName("Please Stop (Original Mix)XPTO");
        music.setStyle(Style.TECH_HOUSE.name());

        getMusicServiceBean().create(music);

    }


	private MusicService getMusicServiceBean() {
		return musicService;
	}


//	public void setMusicServiceBean(MusicService musicServiceBean) {
//		this.musicService = musicServiceBean;
//	}


	private SampleService getSampleServiceBean() {
		return sampleService;
	}


//	public void setSampleServiceBean(SampleService sampleServiceBean) {
//		this.sampleService = sampleServiceBean;
//	}


	private SampleMatchService getSampleMatchServiceBean() {
		return sampleMatchService;
	}

//
//	public void setSampleMatchServiceBean(SampleMatchService sampleMatchServiceBean) {
//		this.sampleMatchService = sampleMatchServiceBean;
//	}

}