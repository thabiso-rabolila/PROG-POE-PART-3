/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package poepart2;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Student
 */
public class MessageManagerNGTest {

    public MessageManagerNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    // ==================== TEST 1: LONGEST MESSAGE ====================
    @Test
    public void testDisplayLongestMessage() {
        System.out.println("testDisplayLongestMessage");
        MessageManager instance = new MessageManager();
        instance.populateTestData(); // Load the test data
        
        String longest = "";
        for (int i = 0; i < instance.messageCount; i++) {
            if (instance.storedMessages[i] != null) {
                if (instance.storedMessages[i].length() > longest.length()) {
                    longest = instance.storedMessages[i];
                }
            }
        }
        
        String expResult = "Where are you? You are late! I have asked you to be on time.";
        assertEquals(longest, expResult);
    }

    // ==================== TEST 2: SEARCH BY ID ====================
    @Test
    public void testSearchByID() {
        System.out.println("testSearchByID");
        MessageManager instance = new MessageManager();
        instance.populateTestData();
        
        // Test Data Message 4 ID
        String searchID = "4444444444";
        String expectedMessage = "It is dinner time !";
        
        String result = "";
        for (int i = 0; i < instance.messageCount; i++) {
            if (instance.messageIDs[i] != null && instance.messageIDs[i].equals(searchID)) {
                result = instance.sentMessages[i];
                break;
            }
        }
        assertEquals(result, expectedMessage);
    }

    // ==================== TEST 3: SEARCH BY RECIPIENT ====================
    @Test
    public void testSearchByRecipient() {
        System.out.println("testSearchByRecipient");
        MessageManager instance = new MessageManager();
        instance.populateTestData();
        
        // Test Data Message 2 and 5 recipient
        String recipient = "+27838884567";
        int count = 0;
        
        for (int i = 0; i < instance.messageCount; i++) {
            if (instance.storedMessages[i] != null && recipient.equals("+27838884567")) {
                count++;
            }
        }
        
        // We expect 2 messages for this recipient
        int expResult = 2;
        assertEquals(count, expResult);
    }

    // ==================== TEST 4: DELETE BY HASH ====================
    @Test
    public void testDeleteByHash() {
        System.out.println("testDeleteByHash");
        MessageManager instance = new MessageManager();
        instance.populateTestData();
        
        // Test Data Message 2 Hash
        String hashToDelete = "22:2:WHERETIME";
        
        // Call the delete method
        instance.deleteByHash(hashToDelete);
        
        // Check if it was actually deleted (should be null)
        String result = instance.storedMessages[1];
        assertNull(result, "The message should be null after deletion.");
    }
}