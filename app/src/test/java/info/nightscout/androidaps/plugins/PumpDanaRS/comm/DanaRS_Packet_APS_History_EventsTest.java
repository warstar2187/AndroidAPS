package info.nightscout.androidaps.plugins.PumpDanaRS.comm;


import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import info.AAPSMocker;
import info.nightscout.androidaps.MainApp;
import info.nightscout.androidaps.logging.L;
import info.nightscout.androidaps.plugins.ConfigBuilder.ConfigBuilderPlugin;
import info.nightscout.utils.SP;
import info.nightscout.utils.ToastUtils;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rumen on 31.07.2018.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({MainApp.class, SP.class, L.class})
public class DanaRS_Packet_APS_History_EventsTest extends DanaRS_Packet_APS_History_Events {

    @Test
    public void runTest() {
        AAPSMocker.mockMainApp();
        AAPSMocker.mockApplicationContext();
        AAPSMocker.mockSP();
        AAPSMocker.mockBus();
        // This testing fails because of unpropper context mocking
        /* try {
            AAPSMocker.mockTreatmentService();
        } catch (Exception e) {
            // exception caught
        }
        DanaRS_Packet_APS_History_Events testPacket = new DanaRS_Packet_APS_History_Events(System.currentTimeMillis());

        // test message decoding
        testPacket.handleMessage(createArray(50, (byte) 0));
        assertEquals(false, failed);
        testPacket.handleMessage(createArray(50, (byte) 1));
        assertEquals(true, failed); */

        assertEquals("APS_HISTORY_EVENTS", getFriendlyName());
    }

    byte[] createArray(int length, byte fillWith){
        byte[] ret = new byte[length];
        for(int i = 0; i<length; i++){
            ret[i] = fillWith;
        }
        return ret;
    }

}
