package de.leuphana.mensaplus.service;

import de.leuphana.mensaplus.model.Essen;
import de.leuphana.mensaplus.repository.EssenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EssenService {

    @Autowired
    private EssenRepository essenRepository;

    public List<Essen> getSpeisekarte() {
        return essenRepository.findAll();
    }

    public Optional<Essen> getEssenById(int id) {
        return essenRepository.findById(id);
    }

    public void addEssen(Essen essen) {
        essenRepository.save(essen);
    }

    // Remove Essen from Essensplan first. then remove Essen
    @Transactional
    public void deleteEssenById(int id) {
        essenRepository.deleteEssenFromEssensplanById(id);
        essenRepository.deleteById(id);
    }

    public Essen updateEssen(Essen essen) {
        return essenRepository.save(essen);
    }
}
