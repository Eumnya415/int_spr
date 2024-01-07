package kr.co.chunjae.service;

import kr.co.chunjae.dto.StudentDTO;
import kr.co.chunjae.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

// 비즈니스 로직 계층
// StudentRepository를 통해 데이터 액세스 계층과 상호작용하여 필요한 기능 수행
@Service

// studentRepository 필드에 대한 생성자를 자동으로 생성
@RequiredArgsConstructor
@Log4j2

public class StudentService {
    private final StudentRepository studentRepository;

    // 학생 정보를 저장하는 메서드
    public void save(StudentDTO studentDTO) {
        studentRepository.save(studentDTO);
    }

    // 모든 학생 목록을 조회하는 메서드
    public List<StudentDTO> findAll(StudentDTO studentDTO) {
        return studentRepository.findAll(studentDTO);
    }

    // 회원 ID를 기준으로 학생 정보를 조회하여 로그인 여부를 반환하는 메서드
    public Boolean findByMemId(StudentDTO studentDTO) {
        StudentDTO dto = studentRepository.findByMemId(studentDTO);
        if (dto != null) {
            return true;
        } else {
            return false;
        }
    }

    // 학생 ID를 기준으로 학생 정보를 조회하는 메서드
    public StudentDTO findByStudentId(String studentId) {
        return studentRepository.findByStudentId(studentId);
    }

    // 학생 정보를 업데이트하는 메서드
    public boolean update(StudentDTO studentDTO) {
        int result = studentRepository.update(studentDTO);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    // 학생 정보를 삭제하는 메서드
    public void delete(String studentId) {
        studentRepository.delete(studentId);
    }
}


