package com.perfectmatch.web.integration;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.perfectmatch.perfectmatch.persistence.dao.feature.AdderServiceSteps;
import com.perfectmatch.web.services.AdderService;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.junit.spring.integration.SpringIntegrationMethodRule;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = AdderService.class)
public class AdderMethodDirtiesContextIntegrationTest {

  @Steps private AdderServiceSteps adderServiceSteps;

  @Rule public SpringIntegrationMethodRule springIntegration = new SpringIntegrationMethodRule();

  @Test
  @DirtiesContext
  public void _0_givenNumber_whenAddAndAccumulate_thenSummedUp() {
    adderServiceSteps.givenBaseAndAdder(2, 6);
    adderServiceSteps.whenAccumulate();
    adderServiceSteps.summedUp();

    adderServiceSteps.whenAdd();
    adderServiceSteps.sumWrong();
  }

  @Test
  public void _1_givenNumber_whenAdd_thenSumWrong() {
    adderServiceSteps.whenAdd();
    adderServiceSteps.sumWrong();
  }
}
