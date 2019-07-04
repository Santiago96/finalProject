package com.globant.bootcamp.airlines.logger;


import com.globant.bootcamp.airlines.AirlinesApplication;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AirlinesApplication.class);

    @Before("execution(* com.globant.bootcamp.airlines.repositories.AirlineRepository.save(..))")
    public void savingRecordAirline(){
        logger.info("Trying to save new record in Airline Table");
    }

    @After("execution(* com.globant.bootcamp.airlines.repositories.AirlineRepository.findAll(..))")
    public void consultingInformationAirline(){
        logger.info("The client has queried information about all airlines");
    }
    @After("execution(* com.globant.bootcamp.airlines.repositories.AirlineRepository.findById(..))")
    public void consultingInformationAirlineById(){
        logger.info("The client has queried information about specific airlines");
    }

    @After("execution(* com.globant.bootcamp.airlines.repositories.AirlineRepository.deleteById(..))")
    public void deletingInformationAirlineById(){
        logger.info("The client has deleted a record");
    }

    @Before("execution(* com.globant.bootcamp.airlines.repositories.FlightRepository.save(..))")
    public void savingRecordFlight(){
        logger.info("Trying to save new record in Flight Table");
    }

    @After("execution(* com.globant.bootcamp.airlines.repositories.FlightRepository.findAll(..))")
    public void consultingInformationFlight(){
        logger.info("The client has queried information about all flight");
    }
    @After("execution(* com.globant.bootcamp.airlines.repositories.FlightRepository.findById(..))")
    public void consultingInformationFlightById(){
        logger.info("The client has queried information about specific flight");
    }

    @After("execution(* com.globant.bootcamp.airlines.repositories.FlightRepository.deleteById(..))")
    public void deletingInformationFlightById(){
        logger.info("The client has deleted a record");
    }
    @After("execution(* com.globant.bootcamp.airlines.repositories.FlightRepository.findByAirline_idAndId(..))")
    public void findingInformationFlightByAirlineId(){
        logger.info("The client has queried Airlines' flights");
    }

}
