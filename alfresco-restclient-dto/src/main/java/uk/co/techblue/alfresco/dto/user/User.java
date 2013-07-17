package uk.co.techblue.alfresco.dto.user;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import uk.co.techblue.alfresco.dto.BaseDto;
import uk.co.techblue.alfresco.jackson.ISO8601DateDeserializer;

public class User extends BaseDto {

	private static final long serialVersionUID = -3009100093342107112L;

	@JsonProperty("url")
	private String url;
	
	@JsonProperty("userName")
	private String userName;
	
	@JsonProperty("enabled")
	private boolean enabled;
	
	@JsonProperty("avatar")
	private String avatar;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("jobtitle")
	private String jobtitle;

	@JsonProperty("organization")
	private String organization;

	@JsonProperty("location")
	private String location;

	@JsonProperty("telephone")
	private String telephone;

	@JsonProperty("mobile")
	private String mobile;

	@JsonProperty("email")
	private String email;

	@JsonProperty("companyaddress1")
	private String companyaddress1;

	@JsonProperty("companyaddress2")
	private String companyaddress2;

	@JsonProperty("companyaddress3")
	private String companyaddress3;

	@JsonProperty("companypostcode")
	private String companypostcode;
	
	@JsonProperty("companytelephone")
	private String companytelephone;
	
	@JsonProperty("companyfax")
	private String companyfax;
	
	@JsonProperty("companyemail")
	private String companyemail;
	
	@JsonProperty("skype")
	private String skype;
	
	@JsonProperty("instantmsg")
	private String instantmsg;
	
	@JsonProperty("userStatus")
	private String userStatus;
	
	@JsonProperty("userStatusTime")
	@JsonDeserialize(using = ISO8601DateDeserializer.class)
	private Date userStatusTime;
	
	@JsonProperty("googleusername")
	private String googleusername;
	
	@JsonProperty("quota")
	private int quota;
	
	@JsonProperty("sizeCurrent")
	private int sizeCurrent;
	
	@JsonProperty("emailFeedDisabled")
	private boolean emailFeedDisabled;
	
	@JsonProperty("persondescription")
	private String persondescription;
	
	@JsonProperty("capabilities")
	private UserCapabilities capabilities;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyaddress1() {
		return companyaddress1;
	}

	public void setCompanyaddress1(String companyaddress1) {
		this.companyaddress1 = companyaddress1;
	}

	public String getCompanyaddress2() {
		return companyaddress2;
	}

	public void setCompanyaddress2(String companyaddress2) {
		this.companyaddress2 = companyaddress2;
	}

	public String getCompanyaddress3() {
		return companyaddress3;
	}

	public void setCompanyaddress3(String companyaddress3) {
		this.companyaddress3 = companyaddress3;
	}

	public String getCompanypostcode() {
		return companypostcode;
	}

	public void setCompanypostcode(String companypostcode) {
		this.companypostcode = companypostcode;
	}

	public String getCompanytelephone() {
		return companytelephone;
	}

	public void setCompanytelephone(String companytelephone) {
		this.companytelephone = companytelephone;
	}

	public String getCompanyfax() {
		return companyfax;
	}

	public void setCompanyfax(String companyfax) {
		this.companyfax = companyfax;
	}

	public String getCompanyemail() {
		return companyemail;
	}

	public void setCompanyemail(String companyemail) {
		this.companyemail = companyemail;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getInstantmsg() {
		return instantmsg;
	}

	public void setInstantmsg(String instantmsg) {
		this.instantmsg = instantmsg;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Date getUserStatusTime() {
		return userStatusTime;
	}

	public void setUserStatusTime(Date userStatusTime) {
		this.userStatusTime = userStatusTime;
	}

	public String getGoogleusername() {
		return googleusername;
	}

	public void setGoogleusername(String googleusername) {
		this.googleusername = googleusername;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public int getSizeCurrent() {
		return sizeCurrent;
	}

	public void setSizeCurrent(int sizeCurrent) {
		this.sizeCurrent = sizeCurrent;
	}

	public boolean isEmailFeedDisabled() {
		return emailFeedDisabled;
	}

	public void setEmailFeedDisabled(boolean emailFeedDisabled) {
		this.emailFeedDisabled = emailFeedDisabled;
	}

	public String getPersondescription() {
		return persondescription;
	}

	public void setPersondescription(String persondescription) {
		this.persondescription = persondescription;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public UserCapabilities getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(UserCapabilities capabilities) {
		this.capabilities = capabilities;
	}

}
