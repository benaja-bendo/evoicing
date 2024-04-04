package invoicing.backend.repositories;

import invoicing.backend.models.Facture;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FactureRepository extends MongoRepository<Facture, Long> {
}
