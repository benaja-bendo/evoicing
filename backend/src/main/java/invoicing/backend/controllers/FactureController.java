package invoicing.backend.controllers;

import invoicing.backend.models.Facture;
import invoicing.backend.repositories.FactureRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facture")
public class FactureController {

    private final FactureRepository factureRepository;

    public FactureController(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    @PostMapping("")
    public Facture createFacture(@RequestBody Facture facture) {
        return factureRepository.save(facture);
    }

    @GetMapping("")
    public List<Facture> readFactures() {
        return factureRepository.findAll();
    }

    @GetMapping("/{id}")
    public Facture readFacture(@PathVariable Long id) {
        return factureRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Facture updateFacture(@PathVariable Long id, @RequestBody Facture newFacture) {

        return factureRepository.findById(id)
                .map(factureRepository::save)
                .orElseGet(() -> {
                    newFacture.setId(id);
                    return factureRepository.save(newFacture);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable Long id) {
        factureRepository.deleteById(id);
    }
}