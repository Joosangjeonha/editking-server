package sogang.capstone.editking.form.presentation;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sogang.capstone.editking.form.application.FormCatalogService;
import sogang.capstone.editking.form.application.dto.FormCatalogDTO;
import sogang.capstone.editking.form.application.dto.FormCatalogListDTO;
import sogang.capstone.editking.global.config.CommonResponse;
import sogang.capstone.editking.user.domain.User;

@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
public class FormCatalogController {

    private final FormCatalogService formCatalogService;

    @Operation(summary = "작성 중인 / 작성 완료한 자기소개서")
    @GetMapping(value = "", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse<FormCatalogListDTO> readFormCatalog(@AuthenticationPrincipal User user,
            @RequestParam String status, @RequestParam Integer limit) {

        List<FormCatalogDTO> formCatalogDTOList = formCatalogService.readFormCatalog(user, status, limit);

        return CommonResponse.onSuccess(new FormCatalogListDTO(formCatalogDTOList));
    }
}
