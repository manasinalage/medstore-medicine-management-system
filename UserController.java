package medstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MedicineService medicineService;

    // ------------------ Public Pages ------------------
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserModel user, Model model) {
        if (userService.getUserByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Username already exists!");
            return "register";
        }
        user.setRole("user");
        userService.saveUser(user);
        model.addAttribute("message", "✅ Registration Successful! Login now.");
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        UserModel user = userService.getUserByUsername(username);

        if (user == null) {
            model.addAttribute("message", "❌ Username not found!");
            return "login";
        }
        if (!user.getPassword().equals(password)) {
            model.addAttribute("message", "❌ Wrong Password!");
            return "login";
        }

        if ("admin".equalsIgnoreCase(user.getRole())) {
            model.addAttribute("users", userService.getAllUsers());
            return "admindashboard";
        }

        model.addAttribute("user", user);
        model.addAttribute("medicines", medicineService.getAllMedicines());
        return "userdashboard";
    }

    @GetMapping("/logout")
    public String logout() {
        // Just redirect to login (no session usage as per your request)
        return "redirect:/login";
    }

    // ------------------ Admin User Management ------------------
    @GetMapping("/viewusers")
    public String viewUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "viewusers";
    }

    @GetMapping("/adduser")
    public String addUserForm(Model model) {
        model.addAttribute("user", new UserModel());
        return "adduser";
    }

    @PostMapping("/adduser")
    public String saveUser(@ModelAttribute UserModel user) {
        userService.saveUser(user);
        return "redirect:/viewusers";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id).orElse(null));
        return "updateuser";
    }

    // ✅ Correct delete mapping: Use GET for simplicity or POST for RESTful
    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
        return "redirect:/viewusers";
    }


    @GetMapping("/admindashboard")
    public String adminDashboard() {
        return "admindashboard";
    }
}
