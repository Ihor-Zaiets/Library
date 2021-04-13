package empire.of.lord.library.dao;

import empire.of.lord.library.models.Anime;
import empire.of.lord.library.models.AnimeRepo;
import empire.of.lord.library.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AnimeDAO {

    private final AnimeRepo animeRepo;

    @Autowired
    public AnimeDAO(AnimeRepo animeRepo) {
        this.animeRepo = animeRepo;
    }

    public Iterable<Anime> showAll(){
        return animeRepo.findAll();
    }

    public Optional<Anime> show(Long id){
        return animeRepo.findById(id);
    }

    public void create(Anime anime){
        animeRepo.save(anime);
    }

    public void update(Anime updatedAnime){
        animeRepo.save(updatedAnime);
    }

    public void delete(Long id){
        animeRepo.deleteById(id);
    }
}