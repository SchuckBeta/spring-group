package com.example;

@DBDesc(title = "Person人", remark = "Person所有的人的总称")
public class Person {

	@DBDesc(title = "Person-sname", remark = "Person---sname")
	public String sname;
	

	@DBDesc(title = "Person-haha", remark = "Person---haha")
	public String haha;

	public String getName() {
		return null;
	}

	@DBDesc(title = "設置名稱", remark = "設置名稱")
	public void setName(String name) {
	}

	public Integer getAge() {
		return 0;
	}

	@DBDesc(title = "设置年龄", remark = "setAge设置年龄")
	public void setAge(Integer age) {
	}

	public String getEmail() {
		return null;
	}

	public void setEmail(String email) {
	}
}
