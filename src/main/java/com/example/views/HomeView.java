package com.example.views;

import com.example.models.ContactModel;
import com.example.views.common.ViewBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HomeView extends ViewBase {

    private final String NEW_CONTACT_ID = "com.brubank.qappsbrubankinterview:id/new_button";
    private final String CONTACTS_TEXT_ID = "com.brubank.qappsbrubankinterview:id/name";
    private final String ORDER_BY_LASTNAME_ID = "com.brubank.qappsbrubankinterview:id/lastname_button";
    private final String ORDER_BY_NAME_ID = "com.brubank.qappsbrubankinterview:id/name_button";

    public boolean isHomeDisplayed() {
        return isPresent(By.id(NEW_CONTACT_ID));
    }

    public void clickOrderByLastName() {
        click(By.id(ORDER_BY_LASTNAME_ID));
    }

    public void clickOrderByFirstName() {
        click(By.id(ORDER_BY_NAME_ID));
    }

    public List<ContactModel> getContactsList() {
        List<WebElement> elements = getElements(By.id(CONTACTS_TEXT_ID));
        List<ContactModel> contacts = new ArrayList<>();
        for (WebElement element : elements) {
            String[] split = getText(element).split(" ");
            //TODO: ver como hace el sort cuando tiene segundo nombre
            ContactModel contact = new ContactModel(split[0], split[split.length - 1]);
            contacts.add(contact);
        }
        return contacts;
    }

    //TODO: mover a un service con logica de negocio
    public List<ContactModel> sortByFirstName(List<ContactModel> list) {
        List<ContactModel> newList = new ArrayList<>();
        newList.addAll(list);
        newList.sort(Comparator.comparing(ContactModel::getFirstName));
        return newList;
    }

    public List<ContactModel> sortByLastName(List<ContactModel> list) {
        List<ContactModel> newList = new ArrayList<>();
        newList.addAll(list);
        newList.sort(Comparator.comparing(ContactModel::getLastName));
        return newList;
    }
}
