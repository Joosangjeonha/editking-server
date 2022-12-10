package sogang.capstone.editking.presentation.interview;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import sogang.capstone.editking.domain.interview.InterviewInfo;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface InterviewResponseMapper {

    InterviewResponse.InterviewMain of(InterviewInfo.InterviewMain mainResult);

}
