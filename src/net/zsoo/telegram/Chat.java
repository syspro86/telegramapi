package net.zsoo.telegram;

public class Chat {
	private long id;
	private String type;
	private String title;
	private String username;
	private String first_name;
	private String last_name;
	private Object photo;
	private String description;
	private String invite_link;
	private Object pinned_message;
	private Object permissions;
	private String sticker_set_name;
	private boolean can_set_sticker_set;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Object getPhoto() {
		return photo;
	}

	public void setPhoto(Object photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInvite_link() {
		return invite_link;
	}

	public void setInvite_link(String invite_link) {
		this.invite_link = invite_link;
	}

	public Object getPinned_message() {
		return pinned_message;
	}

	public void setPinned_message(Object pinned_message) {
		this.pinned_message = pinned_message;
	}

	public Object getPermissions() {
		return permissions;
	}

	public void setPermissions(Object permissions) {
		this.permissions = permissions;
	}

	public String getSticker_set_name() {
		return sticker_set_name;
	}

	public void setSticker_set_name(String sticker_set_name) {
		this.sticker_set_name = sticker_set_name;
	}

	public boolean isCan_set_sticker_set() {
		return can_set_sticker_set;
	}

	public void setCan_set_sticker_set(boolean can_set_sticker_set) {
		this.can_set_sticker_set = can_set_sticker_set;
	}
}
