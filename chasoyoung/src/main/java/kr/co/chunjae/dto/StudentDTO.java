package kr.co.chunjae.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class StudentDTO {
    private String studentId;
    private String studentName;
    private String memberId;
    private String memberPassword;
    private int korean;
    private int english;
    private int math;
}