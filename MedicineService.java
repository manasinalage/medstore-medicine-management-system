package medstore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepo;

    public List<MedicineModel> getAllMedicines() {
        return medicineRepo.findAll();
    }

    public void saveMedicine(MedicineModel medicine) {
        medicineRepo.save(medicine);
    }

    public Optional<MedicineModel> getMedicineById(Long id) {
        return medicineRepo.findById(id);
    }

    public void deleteMedicine(Long id) {
        medicineRepo.deleteById(id);
    }
}
