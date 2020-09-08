package ai.brace;

import java.util.List;

public class AObject {
	private String version;
	private String uuid;
	private String lastModified;
	private String title;
	private String author;
	private String translator;
	private String language;
	private List<TextObj> textArray;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<TextObj> getTextArray() {
		return textArray;
	}
	public void setTextArray(List<TextObj> textArray) {
		this.textArray = textArray;
	}
	
	
}
