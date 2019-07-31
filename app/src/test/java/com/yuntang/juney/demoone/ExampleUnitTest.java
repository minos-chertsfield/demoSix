package com.yuntang.juney.demoone;

import com.yuntang.juney.demoone.bean.User;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    //Junit单元测试

    @Test
    public void MockitoTest() {

        User user = mock(User.class);
        user.setUid("o154672");

        verify(user).setUid("o154672");  //验证

        verifyZeroInteractions(user);

    }

}