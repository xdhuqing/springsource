public class CommentsInValue {

	private String name;


	public void myName(){
		System.out.println(String.format("my name is {%s}", name));
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
