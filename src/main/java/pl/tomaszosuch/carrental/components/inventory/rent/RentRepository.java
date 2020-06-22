package pl.tomaszosuch.carrental.components.inventory.rent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RentRepository extends JpaRepository<Rent, Long> {

    @Query("select a from Rent a where lower(a.rejNumber) like lower(concat('%', :search, '%')) " +
            "or lower(a.vinNumber) like lower(concat('%', :search, '%'))")
    List<Rent> findByRejNumberOrVinNumber(@Param("search") String search);

    Optional<Rent> findByRejNumber(String rejNumber);
}
