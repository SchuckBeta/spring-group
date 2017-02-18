package com.example;

@DBDesc(title="Worker人", remark="Worker所有的人的总称")
@DBTable("person")
public class Worker extends Person {
	@DBDesc(title="姓名", remark="人的姓名")
	@DBColumn("name")
	private String name;

	@DBDesc(title="年龄", remark="人的年龄")
	@DBColumn("age")
	private Integer age;

	@DBDesc(title="邮箱", remark="人的邮箱")
	@DBColumn("email")
	public String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@DBDesc(title="W年龄", remark="W的年龄")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
