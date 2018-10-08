package com.epam.lab.businessobjects;

import com.epam.lab.pageobject.InboxPage;
import org.openqa.selenium.WebDriver;

public class InboxPageBO {
    private InboxPage inboxPage;

    public InboxPageBO(WebDriver driver) {
        inboxPage = new InboxPage(driver);
    }

    public int checkInboxEmailQaontity(){
       return inboxPage.checkInboxEmailQuantity();
    }

    public void selectInboxEmail() {
        inboxPage.selectInboxEmail(0, 1, 2);
    }

    public void deleteEmail() {
        inboxPage.deleteSelectedEmail();
    }

    public void cancelDeletingEmail() {
        inboxPage.clickUndoButton();
    }
}