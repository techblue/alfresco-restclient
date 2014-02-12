/*******************************************************************************
 * Copyright 2012 Technology Blueprint Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package uk.co.techblue.alfresco.dto;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * The Class Timestamp.
 */
public class Timestamp extends BaseDto {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 8819886316476271464L;
		
		/** The iso8601. */
		@JsonProperty
    	private String iso8601;

		/**
		 * Gets the iso8601.
		 *
		 * @return the iso8601
		 */
		public String getIso8601() {
			return iso8601;
		}

		/**
		 * Sets the iso8601.
		 *
		 * @param iso8601 the new iso8601
		 */
		public void setIso8601(String iso8601) {
			this.iso8601 = iso8601;
		}
    	
    }
