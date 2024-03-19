import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class HealthCheck {

    @GetMapping("/health")
    fun check(): String {
        return "OK"
    }
}