package sogang.capstone.editking.presentation.form;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import sogang.capstone.editking.domain.form.FormInfo;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface FormResponseMapper {

    // main
    @Mappings({@Mapping(source = "dueDate", target = "dueDate", dateFormat = "yyyy-MM-dd HH:mm:ss")})
    FormResponse.Main of(FormInfo.Main mainResult);

    FormResponse.CatalogMain of(FormInfo.CatalogMain mainResult);

    @Mappings({@Mapping(source = "dueDate", target = "dueDate", dateFormat = "yyyy-MM-dd HH:mm:ss")})
    FormResponse.CatalogForm of(FormInfo.CatalogForm formList);

    FormResponse.SynonymMain of(FormInfo.SynonymMain mainResult);

    FormResponse.InterviewMain of(FormInfo.InterviewMain mainResult);
}
