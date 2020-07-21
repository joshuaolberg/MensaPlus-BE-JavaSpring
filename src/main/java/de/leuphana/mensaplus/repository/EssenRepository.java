package de.leuphana.mensaplus.repository;

import de.leuphana.mensaplus.model.Essen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EssenRepository extends JpaRepository<Essen, Integer> {

    // Removes every object from Essen from EVERY Essensplan
    @Modifying
    @Query(value = "DELETE FROM essensplan_essen_pro_woche m WHERE m.essen_pro_woche_id = ?1", nativeQuery = true)
    void deleteEssenFromEssensplanById(int id);

}
