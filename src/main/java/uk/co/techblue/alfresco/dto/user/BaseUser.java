package uk.co.techblue.alfresco.dto.user;

import org.codehaus.jackson.annotate.JsonProperty;
import uk.co.techblue.alfresco.dto.BaseDto;

/**
 * The Class BaseUser.
 */
public class BaseUser extends BaseDto {

    /** The first name. */
    @JsonProperty("firstName")
    protected String firstName;

    /** The last name. */
    @JsonProperty("lastName")
    protected String lastName;

    /** The jobtitle. */
    @JsonProperty("jobtitle")
    protected String jobtitle;

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the jobtitle.
     *
     * @return the jobtitle
     */
    public String getJobtitle() {
        return jobtitle;
    }

    /**
     * Sets the jobtitle.
     *
     * @param jobtitle the new jobtitle
     */
    public void setJobtitle(final String jobtitle) {
        this.jobtitle = jobtitle;
    }
}
