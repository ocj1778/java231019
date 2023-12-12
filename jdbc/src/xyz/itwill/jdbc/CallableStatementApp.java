package xyz.itwill.jdbc;

/*
CREATE OR REPLACE PROCEDURE DELETE_STUDENT(VNO IN STUDENT.NO%TYPE
	,VNAME OUT STUDENT.NAME%TYPE) IS
BEGIN
    SELECT NAME INTO VNAME FROM STUDENT WHERE NO=VNO;
    IF SQL%FOUND THEN
        DELETE FROM STUDENT WHERE NO=VNO;
        COMMIT;
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        VNAME := NULL;
END;
/ 
*/

//CallableStatement 객체 : 저장 프로시저를 호출하기 위한 기능을 제공하는 객체

//키보드로 학번을 입력받아 STUDENT 테이블에 저장된 학생정보 중 해당 학번의 학생정보를 삭제하는
//JDBC 프로그램 작성 - 저장 프로시저를 호출하여 학생정보를 삭제 처리
public class CallableStatementApp {
	public static void main(String[] args) {
		ㅠㅕ
	}
}










