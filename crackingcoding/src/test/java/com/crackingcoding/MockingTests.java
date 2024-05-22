// Bad code - rewrite

package com.crackingcoding;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockingTests {
    // @Mock
    // User user; // or use User user = mock(User.class)

    Mocking mocking;

    @Mock
    ApplicationDao applicationDao;

    @BeforeEach
    public void setup() {
        mocking = new Mocking();
    }

    @Test
    @DisplayName("Permission assigned successfully")
    public void assignPermission() {
        User user = mock(User.class);
        /* Method Stubbing: You don't need to fill actual values */
        // can also just call your parameterised constructor or setter methods -
        // user.setRole("admin")
        mocking.setUser(user);
        when(user.getRole()).thenReturn("admin");
        when(user.getUsername()).thenReturn("kayla");

        Assertions.assertEquals(1, mocking.assignPermission());
    }

    @Test
    @DisplayName("Keyword found in posts")
    public void getAllPostsContainingWord() {
        User realUser = new User();
        realUser.setPosts(Arrays.asList("Awesome day", "This place is awesome", "Totally unrelated post"));
        User spyUser = spy(realUser);
        // Stub the getPosts method to return a list of posts:
        // List<String> mockPosts = Arrays.asList("Awesome day", "This place is
        // awesome", "Totally unrelated post");
        List<String> filteredPosts = Arrays.asList("Awesome day", "This place is awesome");
        // when(spyUser.getPosts()).thenReturn(mockPosts);

        // when(spyUser.getAllPostsContainingWord("awesome")).thenReturn(filteredPosts);

        // This is not stubbing or overriding any behavior of spyUser
        // is operating on real data, can use realuser since above stubs arnt being used
        List<String> mockFilteredPosts = spyUser.getAllPostsContainingWord("awesome");

        Assertions.assertEquals(2, filteredPosts.size());
        Assertions.assertEquals(filteredPosts, mockFilteredPosts);
    }

    @Test
    @DisplayName("User updated successfully")
    public void updateUsername() throws Exception {
        User user = new User();
        user.setUsername("Frank");
        lenient().when(applicationDao.getUserById(Mockito.anyString())).thenReturn(user);

        Assertions.assertEquals(1, mocking.updateUsername("3211", "Bobby"));
    }
}