package sogang.capstone.editking.presentation.form;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sogang.capstone.editking.application.form.FormCatalogFacade;
import sogang.capstone.editking.common.response.CommonResponse;
import sogang.capstone.editking.domain.user.User;

@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
public class FormCatalogController {

    private final FormCatalogFacade formCatalogFacade;
    private final FormResponseMapper formResponseMapper;

    @Operation(summary = "작성 중인 / 작성 완료한 자기소개서")
    @GetMapping(value = "", produces = "application/json; charset=utf-8")
    @ResponseBody
    public CommonResponse retrieveFormCatalog(@AuthenticationPrincipal User user,
            @RequestParam String status, @RequestParam Long limit) {

        var formResult = formCatalogFacade.retrieveFormCatalog(user, status, limit);
        var response = formResponseMapper.of(formResult);

        return CommonResponse.onSuccess(response);
    }
}
