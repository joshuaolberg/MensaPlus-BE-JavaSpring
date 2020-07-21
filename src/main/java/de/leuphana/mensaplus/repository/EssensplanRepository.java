package de.leuphana.mensaplus.repository;

import de.leuphana.mensaplus.model.Essensplan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EssensplanRepository extends JpaRepository<Essensplan, Integer> {

}
