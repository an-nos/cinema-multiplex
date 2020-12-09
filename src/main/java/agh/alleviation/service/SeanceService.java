package agh.alleviation.service;

import agh.alleviation.model.*;
import agh.alleviation.persistence.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service responsible for manipulating the seance repository.
 *
 * @author Ksenia Fiodarava
 * @see SeanceRepository
 * @see Seance
 */
@Service
@Transactional
public class SeanceService {
    private final SeanceRepository seanceRepository;

    /**
     * Instantiates a new Seance service.
     *
     * @param seanceRepository the seance repository
     */
    @Autowired
    public SeanceService(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    /**
     * Add seance.
     *
     * @param movie the movie
     * @param hall  the hall
     * @param date  the date
     * @param price the price
     */
    public void addSeance(Movie movie, Hall hall, Date date, double price){
        Seance seance = new Seance(movie, hall, date, price);
        seanceRepository.save(seance);
    }

    /**
     * Get all seances list.
     *
     * @return the list
     */
    public List<Seance> getAllSeances(){
        return StreamSupport.stream(seanceRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}