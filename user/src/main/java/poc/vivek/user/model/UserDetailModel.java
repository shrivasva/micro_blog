package poc.vivek.user.model;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class UserDetailModel {
    @NotNull
    @Size(min = 2)
    private String firstName;
    @NotNull
    @Size(min = 2)
    private String lastName;
    @NotNull
    @Pattern(regexp = "^\\d{10}$")
    private String contactNo;
    @Email
    private String emailId;
    @NotNull
    @Pattern(regexp = "m|f|o", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String gender;
    @NotNull
    @Past
    private LocalDate dob;
    @NotNull
    @Pattern(regexp = "^\\d{6}$")
    private String pincode;
    @NotNull
    @Size(min = 2)
    private String state;
    @NotNull
    @Size(min = 2)
    private String city;
    @NotNull
    @Size(min = 6)
    private String address1;
    private String address2;
    private String landmark;
    @NotNull
    @Size(min = 6)
    private String password;
    @NotNull
    @Size(min = 6)
    private String confirmPassword;

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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
