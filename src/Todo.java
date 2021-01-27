public class Todo implements Serializable{
	private String name;
	private String description;
	private boolean done;
	
	//Does it make sense to be able to make the boolean for done accessible in the declaration?
	//Are you going to add a todo object that is already done?
	public Todo(String name, String description, boolean done) {
		this.name = name;
		this.description = description;
		this.done = done;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	
	@Override
	public String toString() {
		return "Task-[" + name + ". Description: " + description + ". Done: " + done + "]";
	}
	
}