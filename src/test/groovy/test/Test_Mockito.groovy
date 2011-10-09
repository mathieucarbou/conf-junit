package test;


import org.junit.Test
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer
import static com.mycila.junit.matchers.ExceptionMatchers.expression
import static com.mycila.junit.matchers.ExceptionMatchers.thrown
import static org.junit.Assert.*
import static org.mockito.Mockito.*

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
class Test_Mockito {

    @Test
    void verify() {
        List list = mock(List)
        List list2 = mock(List)

        list << 'hello'
        list.clear()
        list << 'world'

        verify(list, times(2)).add(any(String))
        verify(list).clear()
        verifyNoMoreInteractions list

        verifyZeroInteractions list2
    }

    @Test
    void stubbing() {
        List list = mock(List)

        when(list.add('hello')).thenReturn(true).thenReturn(false)

        when(list.add('world')).thenReturn(false)

        when(list.add(1)).thenThrow(new IllegalArgumentException('string required'))

        when(list.get(anyInt())).thenAnswer({InvocationOnMock invocation ->
            if (invocation.arguments[0] == 0)
                return 'java'
            throw new IndexOutOfBoundsException()
        } as Answer)

        assertTrue list.add('hello')
        assertFalse list.add('hello')

        assertFalse list.add('world')

        assertThat(expression {list.add(1)}, thrown(IllegalArgumentException).withMessage('string required'))

        assertEquals 'java', list.get(0)
        assertThat(expression {list.get(1)}, thrown(IndexOutOfBoundsException))
    }

    @Test
    void spying() {
        List list = new ArrayList()

        List spy = spy(list)

        //optionally, you can stub out some methods:
        when(spy.size()).thenReturn(100);

        //using the spy calls real methods
        spy.add("one");
        spy.add("two");

        System.out.println list;
    }
}
