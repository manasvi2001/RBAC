package assig.apurba.rar.web.model;

public interface ProjectUser {
	public String getName();

	public Project getProject();

	public void setProject(Project project);

	public UserRole getRole();

	public void setRole(UserRole role);
}
