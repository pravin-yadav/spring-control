package com.example.projectboard.Model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_profile")
@NoArgsConstructor
public class ProfileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id")
    private Long profileId;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "address")
    private String address;

    @Column(name = "education")
    private String education;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "designation")
    private String designation;

    @OneToOne
    @JoinColumn(name = "user")
    private User user;

    public ProfileModel(Long profileId, String profilePicture, Date dateOfBirth, String gender, String country, String state, String city, String postalCode, String maritalStatus, String address, String education, String occupation, String designation, User user) {
        this.profileId = profileId;
        this.profilePicture = profilePicture;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.country = country;
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
        this.maritalStatus = maritalStatus;
        this.address = address;
        this.education = education;
        this.occupation = occupation;
        this.designation = designation;
        this.user = user;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
