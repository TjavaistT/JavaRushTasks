package com.javarush.task.task20.task2028;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomTreeTest {

    CustomTree.Entry<String> root;
    CustomTree customTree;

    @Before
    public void setUp() {
        customTree = new CustomTree();
        customTree.add("Адам");
        customTree.add("Ева");
        customTree.add("Сим");
        customTree.add("Хам");
        customTree.add("Иофет");
        customTree.add("Авель");
        customTree.add("Каин");
    }

    @Test
    public void testRootAndSize() {
        Assert.assertEquals(7, customTree.size());
    }

    @Test
    public void testGetParent() {
        String currentName = customTree.getParent("Адам");
        Assert.assertEquals("root", currentName);
        Assert.assertEquals("Адам", customTree.getParent("Хам"));
    }

    @Test
    public void testLeftChild() {
        Assert.assertEquals("Сим", customTree.elements[1].leftChild.elementName);
        Assert.assertFalse(customTree.elements[1].availableToAddLeftChildren);
    }

    @Test
    public void testRightChild() {
        Assert.assertEquals("Хам", customTree.elements[1].rightChild.elementName);
        Assert.assertFalse(customTree.elements[1].availableToAddRightChildren);
    }

    @Test
    public void testChildrenAvailable() {
        Assert.assertTrue(customTree.elements[4].isAvailableToAddChildren());
        Assert.assertFalse(customTree.elements[1].isAvailableToAddChildren());
    }

    @Test
    public void testRemove() {
        customTree.remove("Адам");

        Assert.assertNull(customTree.elements[1]);
    }

    @Test
    public void testRemoveLastElement() {
        customTree.remove("Иофет");
        customTree.remove("Авель");
        customTree.remove("Каин");

        Assert.assertEquals(4, customTree.size());
        int lastElementIndex = customTree.size();
        Assert.assertEquals(customTree.elements[lastElementIndex].elementName, "Хам");
    }

    @Test
    public void testRemoveSubtree() {
        customTree.remove("Ева");
        Assert.assertNull(customTree.elements[2]);
        Assert.assertNull(customTree.elements[5]);
        Assert.assertNull(customTree.elements[6]);
        Assert.assertNotNull(customTree.elements[7]);
    }

    @Test
    public void testAddAfterRemove() {
        customTree.remove("Сим");
        customTree.remove("Хам");
        customTree.remove("Иофет");
        customTree.remove("Авель");
        String elName = "Руфь";
        customTree.add("Руфь");
        Assert.assertNotNull(customTree.elements[3]);
        Assert.assertEquals(elName, customTree.elements[3].elementName);
        Assert.assertEquals("Адам", customTree.elements[3].parent.elementName);
        Assert.assertEquals("Адам", customTree.getParent(elName));
    }

    @Test
    public void testChildRenAvailableAfterRemoveLastElement() {
        customTree.remove("Сим");
        customTree.remove("Хам");
        customTree.remove("Каин");
        customTree.remove("Авель");
        customTree.remove("Иофет");

        Assert.assertTrue(customTree.elements[2].availableToAddLeftChildren);
        Assert.assertTrue(customTree.elements[2].availableToAddRightChildren);

        Assert.assertTrue(customTree.elements[1].availableToAddLeftChildren);
        Assert.assertTrue(customTree.elements[1].availableToAddRightChildren);
    }

    @After
    public void tearDown() {
        customTree = new CustomTree();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme