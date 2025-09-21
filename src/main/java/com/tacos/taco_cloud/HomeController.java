@controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }