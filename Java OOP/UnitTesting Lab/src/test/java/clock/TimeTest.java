package clock;

import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertTrue;

public class TimeTest {
    @Test
    public void testIfClockIsRingingAtMorning() {
        Time mockedTime = Mockito.mock(Time.class);
        Mockito.when(mockedTime.checkIfIsMorning()).thenReturn(true);
        AlarmClock alarmClock = new AlarmClock(mockedTime);
        assertTrue(alarmClock.ring());
    }
}
