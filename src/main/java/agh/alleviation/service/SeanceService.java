package agh.alleviation.service;

import agh.alleviation.model.*;
import agh.alleviation.persistence.HallRepository;
import agh.alleviation.persistence.MovieRepository;
import agh.alleviation.persistence.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Service responsible for manipulating the seance repository.
 *
 * @author Ksenia Fiodarava
 * @see SeanceRepository
 * @see Seance
 */
@Service
@Transactional
public class SeanceService extends EntityObjectService<Seance, SeanceRepository> {

    private MovieRepository movieRepository;
    private HallRepository hallRepository;

    /**
     * Instantiates a new Seance service.
     *
     * @param seanceRepository the seance repository
     */
    @Autowired
    public SeanceService(SeanceRepository seanceRepository, MovieRepository movieRepository, HallRepository hallRepository) {
        this.repository = seanceRepository;
        this.movieRepository = movieRepository;
        this.hallRepository = hallRepository;
    }

    public Seance addSeance(Movie movie) {
        Seance seance = new Seance(movie);
        movie = movieRepository.findByIdWithSeances(movie.getId());
        movie.addSeance(seance);
        repository.save(seance);
        return seance;
    }

    public Seance addSeance(Movie movie, Hall hall, LocalDateTime date, double price) {
        Seance seance = addSeance(movie);
        seance.setHall(hall);
        seance.setDate(date);
        seance.setPrice(price);
        hall = hallRepository.findByIdWithSeances(hall.getId());
        hall.addSeance(seance);
        repository.save(seance);
        hallRepository.save(hall);
        return seance;
    }

    public void updateSeance(Seance seance) {
        repository.save(seance);
    }

    /**
     * Get all seances list.
     *
     * @return the list
     */
    public List<Seance> getAllSeances() {
        return (List<Seance>) repository.findAll();
    }

    @Override
    public List<EntityObject> delete(EntityObject seance) {
        seance = repository.findByIdWithTickets(seance.getId());
        return super.delete(seance);
    }

}
