package kr.co.chunjae.repository;

import kr.co.chunjae.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// 데이터 액세스 계층
// DB와 상호작용하여 학생 정보를 저장, 조회, 업데이트, 삭제하는 역할을 수행
@Repository

// SQL 필드에 대한 생성자를 자동으로 생성
@RequiredArgsConstructor
@Log4j2
public class StudentRepository {
    private final SqlSessionTemplate sql;

    // 학생 정보를 저장하는 메서드
    public void save(StudentDTO studentDTO) {
    sql.insert("Student.save", studentDTO);
    }

    // 모든 학생 목록을 조회하는 메서드
    public List<StudentDTO> findAll(StudentDTO studentDTO) {
        return sql.selectList("Student.findAll", studentDTO);
    }

    // 멤버 ID를 기준으로 회원 정보를 조회하는 메서드
    public StudentDTO findByMemId(StudentDTO studentDTO) {
        return sql.selectOne("Student.findByMemId" , studentDTO);
    }

    // 학생 ID를 기준으로 학생 정보를 조회하는 메서드
    public StudentDTO findByStudentId(String studentId) {
        return sql.selectOne("Student.findByStudentId", studentId);
    }

    // 학생 정보를 업데이트하는 메서드
    public int update(StudentDTO studentDTO) {
        return sql.update("Student.update", studentDTO);
    }

    // 학생 정보를 삭제하는 메서드
    public void delete(String studentId) {
        sql.delete("Student.delete", studentId);
    }
}
