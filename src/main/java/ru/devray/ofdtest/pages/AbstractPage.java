package ru.devray.ofdtest.pages;

import ru.devray.ofdtest.util.WDriver;

public abstract class AbstractPage {
    /**
     * Verifies if page active is the desired page
     * (by presence of unique elements, headers, etc.)
     */
    protected static WDriver wd = WDriver.getInstance();

    public abstract void checkPage();

    public abstract void open();
}
