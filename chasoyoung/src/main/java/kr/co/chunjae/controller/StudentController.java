package kr.co.chunjae.controller;

import kr.co.chunjae.dto.StudentDTO;
import kr.co.chunjae.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

// 클래스의 모든 요청 경로 앞에 /student를 추가하도록 설정
@RequestMapping("/student")

// 생성자 인젝션을 위한 롬복 애너테이션
// studentService 필드에 대한 생성자를 자동으로 생성
@RequiredArgsConstructor
@Log4j2
public class StudentController {

    private final StudentService studentService;

    // 학생 등록 페이지로 이동하는 GET 요청 처리
    @GetMapping("save")
    public String saveForm(){
        return "saveForm";
    }

    // 학생 등록을 처리하는 POST 요청 처리
    @PostMapping("save")
    public String save(@ModelAttribute StudentDTO studentDTO){

        // 입력 받은 학생의 정보를 저장
        studentService.save(studentDTO);
        return "redirect:/student/studentList";
    }

    // 학생 목록 페이지로 이동하는 GET 요청 처리
    @GetMapping("studentList")
    public String studentList(StudentDTO studentDTO, Model model){

        // 모든 학생 목록 조회
        List<StudentDTO> list = studentService.findAll(studentDTO);

        // 모델에 학생 목록을 담아 뷰로 전달
        model.addAttribute("studentList", list);
        return "studentList";
    }

    // 로그인 페이지로 이동하는 GET 요청 처리
    @GetMapping("login")
    public String loginForm() {
        return "loginForm";
    }

    // 로그인을 처리하는 POST 요청 처리
    @PostMapping("login")
    public String login(@RequestParam("memberId") String memberId, HttpSession session, StudentDTO studentDTO){

        Boolean loginSuccess = studentService.findByMemId(studentDTO);
        if (loginSuccess){
            session.setAttribute("memberId", memberId);
            log.info("loginSuccess..........." + loginSuccess);
            return "redirect:/student/studentList";
        } else {
            log.info("loginFailed......" + !loginSuccess);
            return "loginForm";
        }
    }


    // 학생 정보 수정 페이지로 이동하는 GET 요청 처리
    @GetMapping("update")
    public String updateForm(@RequestParam("studentId") String studentId, Model model){

        // 학생 ID에 해당하는 학생 정보를 조회
        StudentDTO studentDTO = studentService.findByStudentId(studentId);

        // 모델에 학생 정보를 담아 뷰로 전달
        model.addAttribute("student", studentDTO);
        return "updateForm";
    }

    // 학생 정보 수정을 처리하는 POST 요청을 처리
    @PostMapping("update")
    public String update(@ModelAttribute StudentDTO studentDTO){

        // 학생 정보 업데이트
        boolean result = studentService.update(studentDTO);
        if (result) {

            // 업데이트 성공 시 학생 목록 페이지로 리다이렉트
            return "redirect:/student/studentList";
        } else {

            // 업데이트 실패 시 로그인 페이지로 이동
            return "loginForm";
        }
    }

    // 학생 정보 삭제를 처리하는 GET 요청 처리
    @GetMapping("delete")
    public String delete(@RequestParam("studentId") String studentId) {

        // 학생 정보를 삭제
        studentService.delete(studentId);
        return "redirect:/student/studentList";
    }
}
