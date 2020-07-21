package de.leuphana.mensaplus.controller;

import de.leuphana.mensaplus.model.Essen;
import de.leuphana.mensaplus.service.EssenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/essen")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EssenController {

    @Autowired
    private EssenService essenService;

    @GetMapping
    public List<Essen> getSpeisekarte() {
        return essenService.getSpeisekarte();
    }

    @GetMapping(value = "/{id}")
    public Optional<Essen> getEssenById(@PathVariable("id") int id) {
        return essenService.getEssenById(id);
    }

    @PostMapping
    public ResponseEntity<Essen> addEssen(@RequestBody Essen essen) {
        essenService.addEssen(essen);
        return new ResponseEntity<>(essen, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEssenById(@PathVariable("id") int id) {
        essenService.deleteEssenById(id);
    }

    @PutMapping
    public Essen updateEssen(@RequestBody Essen essen) {
        return essenService.updateEssen(essen);
    }
}
