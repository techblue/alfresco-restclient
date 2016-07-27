package uk.co.techblue.alfresco.dto;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * The Class BaseStatus.
 */
public class BaseStatus extends BaseDto {

    /** The code. */
    @JsonProperty
    protected int code;

    /** The name. */
    @JsonProperty
    protected String name;

    /** The description. */
    @JsonProperty
    protected String description;

    /**
     * Gets the code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    public void setCode(final int code) {
        this.code = code;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

}
