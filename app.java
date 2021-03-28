import java.io.Serializable;

public class app implements Serializable {
	String name, developer;
	
	public app(String name, String developer) {
		this.name = name;
		this.developer = developer;
	}
	
	public app(app a){
		name = a.name;
		developer = a.developer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	
	public String toString() {
		return ("App name: " + name + " App Developer: " + developer);
	}
}
