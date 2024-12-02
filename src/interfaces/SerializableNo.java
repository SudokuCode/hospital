package interfaces;

import devices.SerialException;

import java.io.Serializable;

public interface SerializableNo extends Serializable {
    String getSerialNumber() throws SerialException;
}
