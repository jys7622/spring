package com.webjjang.image.vo;

import java.util.Date;

import lombok.Data;


//lombok 라이브러리가 저장할 당시(컴파일 할 때) - 생성자, setter, getter, toString을 자동으로 만들어 준다.
@Data
public class imageVO {
	
	private long no;
	private String title;
	private String contet;
	private String id;
	private Date writeDate;
	private String fileName;

}
