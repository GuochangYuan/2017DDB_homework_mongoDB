package common.ztree;

public class TreeNode {
	
	private String id;
	private String pId;
	private String name;
	private boolean checked;
	private boolean open;
	private boolean isParent;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	 
	/**
	 * @return the pId
	 */
	public String getpId() {
		return pId;
	}
	/**
	 * @param pId the pId to set
	 */
	public void setpId(String pId) {
		this.pId = pId;
	}
	/**
	 * @return the isParent
	 */
	public boolean isParent() {
		return isParent;
	}
	/**
	 * @param isParent the isParent to set
	 */
	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}

}
