package medstore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/all")
    public String allMedicines(Model model) {
        model.addAttribute("medicines", medicineService.getAllMedicines());
        return "viewmedicines";
    }

    @GetMapping("/add")
    public String addMedicineForm(Model model) {
        model.addAttribute("medicine", new MedicineModel());
        return "addmedicine";
    }

    @PostMapping("/save")
    public String saveMedicine(@ModelAttribute MedicineModel medicine) {
        medicineService.saveMedicine(medicine);
        return "redirect:/medicines/all";
    }

    @GetMapping("/edit/{id}")
    public String editMedicine(@PathVariable Long id, Model model) {
        model.addAttribute("medicine", medicineService.getMedicineById(id).orElse(null));
        return "editmedicine";
    }

    @PostMapping("/update")
    public String updateMedicine(@ModelAttribute MedicineModel medicine) {
        medicineService.saveMedicine(medicine);
        return "redirect:/medicines/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return "redirect:/medicines/all";
    }
}
