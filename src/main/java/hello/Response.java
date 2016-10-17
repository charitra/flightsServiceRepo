package hello;

import java.util.List;

public class Response {

	private String speech;
	private String displayText;
	private List<String> data;
	private List<String> contextOut;
	private String source;
	
	public Response(String speech, String displayText, List<String> data,
			List<String> contextOut, String source) {
		this.speech = speech;
		this.displayText = displayText;
		this.data = data;
		this.contextOut = contextOut;
		this.source = source;
	}
	public String getSpeech() {
		return speech;
	}
	public void setSpeech(String speech) {
		this.speech = speech;
	}
	public String getDisplayText() {
		return displayText;
	}
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}
	public List<String> getContextOut() {
		return contextOut;
	}
	public void setContextOut(List<String> contextOut) {
		this.contextOut = contextOut;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	
}
