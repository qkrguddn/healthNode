package KKKOBUGI.web.service;

import KKKOBUGI.web.domain.dto.ExerciseLogDto;
import KKKOBUGI.web.repository.ExerciseLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExerciseLogService {
    @Autowired
    ExerciseLogRepository exerciseLogRepository;

    //운동기록 저장, 수정
    private ExerciseLogDto saveExerciseLog(ExerciseLogDto exerciseLogDto) {
        return null;
    }

    //운동기록 삭제
    private void deleteExerciseLog(Long id) {

    }

    //운동 하루의 기록 조회
    private List<ExerciseLogDto> getDayLog() {
        return null;
    }

    //달력의 모든 날 기록 조회
    private List<List<ExerciseLogDto>> getMonthLog() {
        return null;
    }

}
//등록, 수정, 삭제, 조회(하루기록 조회, 달력의 모든 날 기록조회)
