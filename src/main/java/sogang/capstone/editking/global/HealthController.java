package sogang.capstone.editking.global;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
public class HealthController {

    @Operation(summary = "헬스 체크")
    @GetMapping(value = "", produces = "application/json; charset=utf-8")
    public String healthCheck() {
        return "Healthy!";
    }
}
