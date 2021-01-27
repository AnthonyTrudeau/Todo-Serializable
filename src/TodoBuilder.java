public class TodoBuilder {
	private String name;
	private String description;
	private boolean done;
	
	public TodoBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public TodoBuilder setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public TodoBuilder setDone(boolean done) {
		this.done = done;
		return this;
	}
	
	public Todo build() {
		return new Todo(name, description, done);
	}
}
