package uk.co.techblue.alfresco.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class Timestamp extends BaseDto {
		private static final long serialVersionUID = 8819886316476271464L;
		@JsonProperty
    	private String iso8601;

		public String getIso8601() {
			return iso8601;
		}

		public void setIso8601(String iso8601) {
			this.iso8601 = iso8601;
		}
    	
    }
