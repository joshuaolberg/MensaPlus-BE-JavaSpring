package de.leuphana.mensaplus.service;

import de.leuphana.mensaplus.model.Essen;
import de.leuphana.mensaplus.model.Essensplan;
import de.leuphana.mensaplus.model.Wochentag;
import de.leuphana.mensaplus.repository.EssenRepository;
import de.leuphana.mensaplus.repository.EssensplanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EssensplanService {

    @Autowired
    private EssensplanRepository essensplanRepository;

    @Autowired
    private EssenRepository essenRepository;

    public List<Essensplan> getEssensplan() {
        return essensplanRepository.findAll();
    }

    public Optional<Essensplan> getEssensplanById(int id) {
        return essensplanRepository.findById(id);
    }

    public void addEssensplan(Essensplan essensplan) {
        essensplanRepository.save(essensplan);
    }

    public Essensplan updateEssensplan(Essensplan essensplan) {
        return essensplanRepository.save(essensplan);
    }

    public void deleteEssensplanById(int id) {
        essensplanRepository.deleteById(id);
    }

    @Transactional
    public ResponseEntity<Essensplan> addEssenToEssensplan(int essensplanId, int essenId, int wochentag) {
        Optional<Essensplan> optionalEssensplan = essensplanRepository.findById(essensplanId);
        Optional<Essen> optionalEssen = essenRepository.findById(essenId);
        if (!(optionalEssensplan.isPresent() && optionalEssen.isPresent())) {
            return null;
        } else {
            Essensplan essensplan = optionalEssensplan.get();
            Essen essen = optionalEssen.get();
            essensplan.getEssenProWoche().put(Wochentag.valueOf(wochentag), essen);
            return new ResponseEntity<>(essensplan, HttpStatus.OK);
        }
    }

    @Transactional
    public ResponseEntity<Essensplan> removeEssenFromEssensplan(int essensplanId, int essenId, int wochentag) {
        Optional<Essensplan> optionalEssensplan = essensplanRepository.findById(essensplanId);
        Optional<Essen> optionalEssen = essenRepository.findById(essenId);

        if (!(optionalEssensplan.isPresent() && optionalEssen.isPresent())) {
            return null;
        } else {
            Essensplan essensplan = optionalEssensplan.get();
            Essen essen = optionalEssen.get();
            essensplan.getEssenProWoche().remove(Wochentag.valueOf(wochentag), essen);
            return new ResponseEntity<>(essensplan, HttpStatus.OK);
        }
    }

}
