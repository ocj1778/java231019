package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

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
	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<학생정보 삭제>>");
		System.out.print("학번 입력 >> ");
		int no=Integer.parseInt(in.readLine());
		System.out.println("==============================================================");
		Connection con=ConnectionFactory.getConnection();
		
		//Connection.prepareCall(String sql) : 저장 프로시저를 호출하는 명령을 전달하여 실행
		//하기 위한 CallableStatement 객체를 반환하는 메소드
		// => CallableStatement 객체를 이용하여 저장 프로시저를 호출하는 명령 - {call 저장프로시저(?,?,...)}
		// => 저장 프로시저 호출시 매개변수에 전달된 값 또는 변수 대신 ?(InParamter 또는 OutParameter) 기호 사용 가능
		// => 저장 프로시저의 InParamter에는 CallableStatement 객체의 setXXX() 메소드를 호출하여 
		//Java 변수값을 전달하고 OutParameter에는 CallableStatement 객체의 registerOutParameter()
		//메소드를 호출하여 저장 프로시저의 실행 결과값을 Java 변수에 저장
		String sql="{call delete_student(?,?)}";
		CallableStatement cstmt=con.prepareCall(sql);
		
		//CallableStatement.setXXX(int parameterIndex, XXX parameterValue)
		// => 저장 프로시저의 IN 모드의 매개변수에 값을 전달하기 위한 메소드
		// => XXX는 Java 자료형을 표현
		cstmt.setInt(1, no);
		
		//CallableStatement.registerOutParameter(int parameterIndex, int sqlType)
		// => 저장 프로시저의 OUT 모드의 매개변수에 저장된 값의 자료형을 제공받기 위한 메소드
		// => sqlType 매개변수에는 DBMS 자료형을 Types 클래스의 상수를 사용하여 전달
		cstmt.registerOutParameter(2, Types.NVARCHAR);
		
		//CallableStatement.execute() : 저장 프로시저를 호출하는 명령을 전달하여 실행하는 메소드
		cstmt.execute();
		
		//CallableStatement.getXXX(int parameterIndex) : 저장 프로시저의 OUT 모드의 매개변수에
		//저장된 값을 반환하는 메소드 - XXX는 Java 자료형을 표현
		String name=cstmt.getString(2);
		
		if(name==null) {//삭제된 행이 없는 경우
			System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다.");
		} else {//삭제된 행이 있는 경우
			System.out.println("[메세지]"+name+"님을 삭제 하였습니다.");
		}
		
		ConnectionFactory.close(con, cstmt);
	}
}
