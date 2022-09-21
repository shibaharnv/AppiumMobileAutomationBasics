package org.example;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class getMacIP {

    public static void main(String[] args) throws SocketException, UnknownHostException {
        String ip=getMacAddress();
        System.out.println(ip);
    }

        public static String getMacAddress() throws UnknownHostException,
                SocketException
        {
            InetAddress ipAddress = InetAddress.getLocalHost();
            NetworkInterface networkInterface = NetworkInterface
                    .getByInetAddress(ipAddress);
            byte[] macAddressBytes = networkInterface.getHardwareAddress();
            StringBuilder macAddressBuilder = new StringBuilder();

            for (int macAddressByteIndex = 0; macAddressByteIndex < macAddressBytes.length; macAddressByteIndex++)
            {
                String macAddressHexByte = String.format("%02X",
                        macAddressBytes[macAddressByteIndex]);
                macAddressBuilder.append(macAddressHexByte);

                if (macAddressByteIndex != macAddressBytes.length - 1)
                {
                    macAddressBuilder.append(":");
                }
            }

            return macAddressBuilder.toString();
        }
    }

