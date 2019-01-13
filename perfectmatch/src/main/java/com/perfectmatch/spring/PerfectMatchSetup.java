package com.perfectmatch.spring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.perfectmatch.persistence.model.Artist;
import com.perfectmatch.persistence.model.Match;
import com.perfectmatch.persistence.model.MatchRule;
import com.perfectmatch.persistence.model.Music;
import com.perfectmatch.persistence.model.PerfectMatch;
import com.perfectmatch.persistence.model.Sample;
import com.perfectmatch.persistence.model.Style;
import com.perfectmatch.web.services.ArtistService;
import com.perfectmatch.web.services.MusicService;
import com.perfectmatch.web.services.PerfectMatchService;
import com.perfectmatch.web.services.SampleMatchService;
import com.perfectmatch.web.services.SampleService;

/**
 * This simple setup class will run during the bootstrap process of Spring and
 * will create some setup data <br>
 * The main focus here is creating some Music artist, Samples and Samples'
 * matches
 */
@Component
public class PerfectMatchSetup implements ApplicationListener<ContextRefreshedEvent> {

  // Only for setup purposes
  private boolean setupDone;

  @Autowired private ArtistService artistService;

  @Autowired private MusicService musicService;

  @Autowired private SampleService sampleService;

  @Autowired private SampleMatchService sampleMatchService;

  @Autowired private PerfectMatchService perfectMatchService;

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

    Artist latmun = Artist.builder()
						.name("Latmun")
						.build();

    if (Objects.isNull(artistService.getArtistByName(latmun.getName()))) {
      latmun = artistService.createArtist(latmun);
    }

    Music musicPleaseStop = new Music();
    musicPleaseStop.setArtists(Arrays.asList(latmun.getName()));
    musicPleaseStop.setName("Please Stop (Original Mix)");
    musicPleaseStop.setStyle(Style.TECH_HOUSE.name());
    musicPleaseStop.setTempo("145");
    musicPleaseStop.setEnergy("9");
    musicPleaseStop.setKey("8B");
    
    Sample samplePleaseStop = new Sample();
    samplePleaseStop.setTimestamp(3 * 60); // Start time stamp at 00:03:00m
    samplePleaseStop.setName(musicPleaseStop.getArtist() + ":" + musicPleaseStop.getName());

    musicPleaseStop.setSamples(new HashSet<Sample>(Arrays.asList(samplePleaseStop)));

    Music musicDef = new Music();
    musicDef.setArtists(Arrays.asList(latmun.getName()));
    musicDef.setName("def (Original Mix)");
    musicDef.setStyle(Style.TECH_HOUSE.name());
    musicDef.setTempo("145");
    musicDef.setEnergy("6");
    musicDef.setKey("4B");
    
    Sample sampleDef = new Sample();
    sampleDef.setTimestamp(3 * 60); // timeStamp at 00:03:00m
    sampleDef.setName(musicDef.getArtist() + ":" + musicDef.getName());

    musicDef.setSamples(new HashSet<Sample>(Arrays.asList(sampleDef)));

    Match newMatch = new Match();
    newMatch.setMusicNameThis(musicPleaseStop.getName());
    newMatch.setMusicNameThat(musicDef.getName());
    newMatch.setRule(MatchRule.DEFAULT.name());

    if (!getSampleMatchServiceBean().contains(newMatch)) {
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

    PerfectMatch newPerfectMatch = new PerfectMatch();
    newPerfectMatch.setName(newMatch.getName());

    if (Objects.isNull(getPerfectMatchServiceBean()
    		.findPerfectMatchByName(newPerfectMatch.getName()))) {
    	getPerfectMatchServiceBean().create(newPerfectMatch);
    }

    // Test insert music without samples and Match

    Artist latmunXPTO =  Artist.builder()
							.name("LatmunXPTO")
							.build();
						    
    

    if (Objects.isNull(artistService.getArtistByName(latmunXPTO.getName()))) {
    	latmunXPTO = artistService.createArtist(latmunXPTO);
    }

    Music music = new Music();
    music.setArtists(Arrays.asList(latmunXPTO.getName()));
    music.setName("Please Stop (Original Mix)XPTO");
    music.setStyle(Style.TECH_HOUSE.name());
    music.setTempo("145");
    music.setEnergy("10");
    music.setKey("2B");
    
    getMusicServiceBean().create(music);
  }

  private MusicService getMusicServiceBean() {
    return musicService;
  }



  private SampleService getSampleServiceBean() {
    return sampleService;
  }



  private PerfectMatchService getPerfectMatchServiceBean() {
    return perfectMatchService;
  }

  private SampleMatchService getSampleMatchServiceBean() {
    return sampleMatchService;
  }

}
