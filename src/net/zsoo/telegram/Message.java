package net.zsoo.telegram;

public class Message {
	private long message_id;
	private Object from;
	private long date;
	private Chat chat;
	private Object forward_from;
	private Object forward_from_chat;
	private int forward_from_message_id;
	private String forward_signature;
	private String forward_sender_name;
	private long forward_date;
	private Message reply_to_message;
	private long edit_date;
	private String media_group_id;
	private String author_signature;
	private String text;
	private Object[] entities;
	private Object[] caption_entities;

	public long getMessage_id() {
		return message_id;
	}

	public void setMessage_id(long message_id) {
		this.message_id = message_id;
	}

	public Object getFrom() {
		return from;
	}

	public void setFrom(Object from) {
		this.from = from;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Object getForward_from() {
		return forward_from;
	}

	public void setForward_from(Object forward_from) {
		this.forward_from = forward_from;
	}

	public Object getForward_from_chat() {
		return forward_from_chat;
	}

	public void setForward_from_chat(Object forward_from_chat) {
		this.forward_from_chat = forward_from_chat;
	}

	public int getForward_from_message_id() {
		return forward_from_message_id;
	}

	public void setForward_from_message_id(int forward_from_message_id) {
		this.forward_from_message_id = forward_from_message_id;
	}

	public String getForward_signature() {
		return forward_signature;
	}

	public void setForward_signature(String forward_signature) {
		this.forward_signature = forward_signature;
	}

	public String getForward_sender_name() {
		return forward_sender_name;
	}

	public void setForward_sender_name(String forward_sender_name) {
		this.forward_sender_name = forward_sender_name;
	}

	public long getForward_date() {
		return forward_date;
	}

	public void setForward_date(long forward_date) {
		this.forward_date = forward_date;
	}

	public Message getReply_to_message() {
		return reply_to_message;
	}

	public void setReply_to_message(Message reply_to_message) {
		this.reply_to_message = reply_to_message;
	}

	public long getEdit_date() {
		return edit_date;
	}

	public void setEdit_date(long edit_date) {
		this.edit_date = edit_date;
	}

	public String getMedia_group_id() {
		return media_group_id;
	}

	public void setMedia_group_id(String media_group_id) {
		this.media_group_id = media_group_id;
	}

	public String getAuthor_signature() {
		return author_signature;
	}

	public void setAuthor_signature(String author_signature) {
		this.author_signature = author_signature;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Object[] getEntities() {
		return entities;
	}

	public void setEntities(Object[] entities) {
		this.entities = entities;
	}

	public Object[] getCaption_entities() {
		return caption_entities;
	}

	public void setCaption_entities(Object[] caption_entities) {
		this.caption_entities = caption_entities;
	}

}
