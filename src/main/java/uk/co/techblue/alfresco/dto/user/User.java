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
package uk.co.techblue.alfresco.dto.user;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import uk.co.techblue.alfresco.dto.BaseDto;
import uk.co.techblue.alfresco.jackson.ISO8601DateDeserializer;

/**
 * The Class User.
 */
public class User extends BaseUser {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3009100093342107112L;

    /** The url. */
    @JsonProperty("url")
    private String url;

    /** The user name. */
    @JsonProperty("userName")
    private String userName;

    /** The enabled. */
    @JsonProperty("enabled")
    private boolean enabled;

    /** The avatar. */
    @JsonProperty("avatar")
    private String avatar;

    /** The organization. */
    @JsonProperty("organization")
    private String organization;

    /** The location. */
    @JsonProperty("location")
    private String location;

    /** The telephone. */
    @JsonProperty("telephone")
    private String telephone;

    /** The mobile. */
    @JsonProperty("mobile")
    private String mobile;

    /** The email. */
    @JsonProperty("email")
    private String email;

    /** The companyaddress1. */
    @JsonProperty("companyaddress1")
    private String companyaddress1;

    /** The companyaddress2. */
    @JsonProperty("companyaddress2")
    private String companyaddress2;

    /** The companyaddress3. */
    @JsonProperty("companyaddress3")
    private String companyaddress3;

    /** The companypostcode. */
    @JsonProperty("companypostcode")
    private String companypostcode;

    /** The companytelephone. */
    @JsonProperty("companytelephone")
    private String companytelephone;

    /** The companyfax. */
    @JsonProperty("companyfax")
    private String companyfax;

    /** The companyemail. */
    @JsonProperty("companyemail")
    private String companyemail;

    /** The skype. */
    @JsonProperty("skype")
    private String skype;

    /** The instantmsg. */
    @JsonProperty("instantmsg")
    private String instantmsg;

    /** The user status. */
    @JsonProperty("userStatus")
    private String userStatus;

    /** The user status time. */
    @JsonProperty("userStatusTime")
    @JsonDeserialize(using = ISO8601DateDeserializer.class)
    private Date userStatusTime;

    /** The googleusername. */
    @JsonProperty("googleusername")
    private String googleusername;

    /** The quota. */
    @JsonProperty("quota")
    private int quota;

    /** The size current. */
    @JsonProperty("sizeCurrent")
    private int sizeCurrent;

    /** The email feed disabled. */
    @JsonProperty("emailFeedDisabled")
    private boolean emailFeedDisabled;

    /** The persondescription. */
    @JsonProperty("persondescription")
    private String persondescription;

    /** The capabilities. */
    @JsonProperty("capabilities")
    private UserCapabilities capabilities;

    /**
     * Gets the url.
     * 
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url.
     * 
     * @param url the new url
     */
    public void setUrl(final String url) {
        this.url = url;
    }

    /**
     * Gets the user name.
     * 
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     * 
     * @param userName the new user name
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    /**
     * Checks if is enabled.
     * 
     * @return true, if is enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the enabled.
     * 
     * @param enabled the new enabled
     */
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Gets the organization.
     * 
     * @return the organization
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * Sets the organization.
     * 
     * @param organization the new organization
     */
    public void setOrganization(final String organization) {
        this.organization = organization;
    }

    /**
     * Gets the location.
     * 
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location.
     * 
     * @param location the new location
     */
    public void setLocation(final String location) {
        this.location = location;
    }

    /**
     * Gets the telephone.
     * 
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets the telephone.
     * 
     * @param telephone the new telephone
     */
    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    /**
     * Gets the mobile.
     * 
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the mobile.
     * 
     * @param mobile the new mobile
     */
    public void setMobile(final String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the email.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     * 
     * @param email the new email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Gets the companyaddress1.
     * 
     * @return the companyaddress1
     */
    public String getCompanyaddress1() {
        return companyaddress1;
    }

    /**
     * Sets the companyaddress1.
     * 
     * @param companyaddress1 the new companyaddress1
     */
    public void setCompanyaddress1(final String companyaddress1) {
        this.companyaddress1 = companyaddress1;
    }

    /**
     * Gets the companyaddress2.
     * 
     * @return the companyaddress2
     */
    public String getCompanyaddress2() {
        return companyaddress2;
    }

    /**
     * Sets the companyaddress2.
     * 
     * @param companyaddress2 the new companyaddress2
     */
    public void setCompanyaddress2(final String companyaddress2) {
        this.companyaddress2 = companyaddress2;
    }

    /**
     * Gets the companyaddress3.
     * 
     * @return the companyaddress3
     */
    public String getCompanyaddress3() {
        return companyaddress3;
    }

    /**
     * Sets the companyaddress3.
     * 
     * @param companyaddress3 the new companyaddress3
     */
    public void setCompanyaddress3(final String companyaddress3) {
        this.companyaddress3 = companyaddress3;
    }

    /**
     * Gets the companypostcode.
     * 
     * @return the companypostcode
     */
    public String getCompanypostcode() {
        return companypostcode;
    }

    /**
     * Sets the companypostcode.
     * 
     * @param companypostcode the new companypostcode
     */
    public void setCompanypostcode(final String companypostcode) {
        this.companypostcode = companypostcode;
    }

    /**
     * Gets the companytelephone.
     * 
     * @return the companytelephone
     */
    public String getCompanytelephone() {
        return companytelephone;
    }

    /**
     * Sets the companytelephone.
     * 
     * @param companytelephone the new companytelephone
     */
    public void setCompanytelephone(final String companytelephone) {
        this.companytelephone = companytelephone;
    }

    /**
     * Gets the companyfax.
     * 
     * @return the companyfax
     */
    public String getCompanyfax() {
        return companyfax;
    }

    /**
     * Sets the companyfax.
     * 
     * @param companyfax the new companyfax
     */
    public void setCompanyfax(final String companyfax) {
        this.companyfax = companyfax;
    }

    /**
     * Gets the companyemail.
     * 
     * @return the companyemail
     */
    public String getCompanyemail() {
        return companyemail;
    }

    /**
     * Sets the companyemail.
     * 
     * @param companyemail the new companyemail
     */
    public void setCompanyemail(final String companyemail) {
        this.companyemail = companyemail;
    }

    /**
     * Gets the skype.
     * 
     * @return the skype
     */
    public String getSkype() {
        return skype;
    }

    /**
     * Sets the skype.
     * 
     * @param skype the new skype
     */
    public void setSkype(final String skype) {
        this.skype = skype;
    }

    /**
     * Gets the instantmsg.
     * 
     * @return the instantmsg
     */
    public String getInstantmsg() {
        return instantmsg;
    }

    /**
     * Sets the instantmsg.
     * 
     * @param instantmsg the new instantmsg
     */
    public void setInstantmsg(final String instantmsg) {
        this.instantmsg = instantmsg;
    }

    /**
     * Gets the user status.
     * 
     * @return the user status
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * Sets the user status.
     * 
     * @param userStatus the new user status
     */
    public void setUserStatus(final String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * Gets the user status time.
     * 
     * @return the user status time
     */
    public Date getUserStatusTime() {
        return userStatusTime;
    }

    /**
     * Sets the user status time.
     * 
     * @param userStatusTime the new user status time
     */
    public void setUserStatusTime(final Date userStatusTime) {
        this.userStatusTime = userStatusTime;
    }

    /**
     * Gets the googleusername.
     * 
     * @return the googleusername
     */
    public String getGoogleusername() {
        return googleusername;
    }

    /**
     * Sets the googleusername.
     * 
     * @param googleusername the new googleusername
     */
    public void setGoogleusername(final String googleusername) {
        this.googleusername = googleusername;
    }

    /**
     * Gets the quota.
     * 
     * @return the quota
     */
    public int getQuota() {
        return quota;
    }

    /**
     * Sets the quota.
     * 
     * @param quota the new quota
     */
    public void setQuota(final int quota) {
        this.quota = quota;
    }

    /**
     * Gets the size current.
     * 
     * @return the size current
     */
    public int getSizeCurrent() {
        return sizeCurrent;
    }

    /**
     * Sets the size current.
     * 
     * @param sizeCurrent the new size current
     */
    public void setSizeCurrent(final int sizeCurrent) {
        this.sizeCurrent = sizeCurrent;
    }

    /**
     * Checks if is email feed disabled.
     * 
     * @return true, if is email feed disabled
     */
    public boolean isEmailFeedDisabled() {
        return emailFeedDisabled;
    }

    /**
     * Sets the email feed disabled.
     * 
     * @param emailFeedDisabled the new email feed disabled
     */
    public void setEmailFeedDisabled(final boolean emailFeedDisabled) {
        this.emailFeedDisabled = emailFeedDisabled;
    }

    /**
     * Gets the persondescription.
     * 
     * @return the persondescription
     */
    public String getPersondescription() {
        return persondescription;
    }

    /**
     * Sets the persondescription.
     * 
     * @param persondescription the new persondescription
     */
    public void setPersondescription(final String persondescription) {
        this.persondescription = persondescription;
    }

    /**
     * Gets the avatar.
     * 
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * Sets the avatar.
     * 
     * @param avatar the new avatar
     */
    public void setAvatar(final String avatar) {
        this.avatar = avatar;
    }

    /**
     * Gets the capabilities.
     * 
     * @return the capabilities
     */
    public UserCapabilities getCapabilities() {
        return capabilities;
    }

    /**
     * Sets the capabilities.
     * 
     * @param capabilities the new capabilities
     */
    public void setCapabilities(final UserCapabilities capabilities) {
        this.capabilities = capabilities;
    }

}
