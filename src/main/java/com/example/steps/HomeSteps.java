package com.example.steps;

import com.example.models.ContactModel;
import com.example.views.HomeView;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class HomeSteps {

    private final String HOME_NOT_DISPLAYED_MESSAGE = "Home view is not displayed.";
    private final String CONTACTS_NOT_SORTED_MESSAGE = "Contacts are not sorted correctly.";
    private HomeView homeView;

    @When("The user sorts by last name in home view")
    public void sortByLastName() {
        getHomeView().clickOrderByLastName();
    }

    @When("The user sorts by first name in home view")
    public void sortByFirstName() {
        getHomeView().clickOrderByFirstName();
    }

    @Then("Home view is displayed")
    public void isHomeViewDisplayed() {
        Assert.assertTrue(getHomeView().isHomeDisplayed(), HOME_NOT_DISPLAYED_MESSAGE);
    }

    @Then("The contacts are sorted by last name")
    public void areContactsSortedByLastName() {
        List<ContactModel> contacts = getHomeView().getContactsList();
        Assert.assertEquals(contacts, getHomeView().sortByLastName(contacts), CONTACTS_NOT_SORTED_MESSAGE);
    }

    @Then("The contacts are sorted by first name")
    public void areContactsSortedByFirstName() {
        List<ContactModel> contacts = getHomeView().getContactsList();
        Assert.assertEquals(contacts, getHomeView().sortByFirstName(contacts), CONTACTS_NOT_SORTED_MESSAGE);
    }

    private HomeView getHomeView() {
        if (homeView == null) {
            homeView = new HomeView();
        }
        return homeView;
    }
}
