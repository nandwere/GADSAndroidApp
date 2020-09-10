package com.nandwere.gadsmobileapplication.model;

public class ProjectSubmit {
    public String firstName;
    public String lastName;
    public String email;
    public String gitHubLink;

    public ProjectSubmit() {
    }

    public ProjectSubmit(String firstName, String lastName, String email, String gitHubLink) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gitHubLink = gitHubLink;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGitHubLink() {
        return gitHubLink;
    }

    public void setGitHubLink(String gitHubLink) {
        this.gitHubLink = gitHubLink;
    }
}
