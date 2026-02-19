package medstore;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineModel, Long> {
    List<MedicineModel> findByNameContaining(String name);
    List<MedicineModel> findByCategory(String category);
    List<MedicineModel> findByCompany(String company);
    List<MedicineModel> findByPriceLessThan(Double price);
    List<MedicineModel> findByQtyLessThan(Integer qty);
    List<MedicineModel> findByExpiryDateBefore(LocalDate date);
}
