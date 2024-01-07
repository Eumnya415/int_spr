package kr.co.chunjae;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// @RequestMapping : 메서드가 처리할 요청 경로 지정
	// "/" 경로로 GET 요청이 들어오면 home 메서드가 처리한다.
	@RequestMapping(value = "/", method = RequestMethod.GET)

	// Locale locale: 요청된 클라이언트의 로케일 정보를 받아옴
	// Model model: 뷰에 전달할 데이터를 담는 모델 객체
	public String home(Locale locale, Model model) {

		// /student/studentList로 리다이렉트하여 학생 목록 페이지로 이동
		return "redirect:/student/studentList";
	}
}