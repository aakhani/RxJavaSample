package com.rxjavasample.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Avdhesh AKhani on 12/6/2016.
 */
public class UserTest {

    @Test
    public void UserNameTest() {
        User u = new User();

        u.setName("foo");

        Assert.assertEquals("foo", u.getName());
    }

    public void failingTest(){
        Assert.assertFalse(true);
    }
}