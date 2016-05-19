package com.duevornHarris;

/**
 * Created by duevornharris on 5/18/16.
 */
public class ConnectionManager {
        int numberOfConnectionsLimit;
        int numberOfConnections;

        public ConnectionManager(){
            numberOfConnectionsLimit = 10;
    }


    public ManagedConnection makeConnection(String IP, String Protocol){
        if(numberOfConnections < numberOfConnectionsLimit) {
            numberOfConnectionsLimit++;
            return new ManagedConnection(IP, "443", Protocol);
        }else {return null;}
    }

    public ManagedConnection customConnection(String IP, String Port){
        if(numberOfConnections < numberOfConnectionsLimit) {
            numberOfConnectionsLimit++;
            return new ManagedConnection(IP, Port, "HTTP");
        }else {return null;}
    }


    private class ManagedConnection implements Connection {

        private String IP;
        private String Port;
        private String Protocol;
        boolean isOpen = true;
        ManagedConnection(String IP, String Port, String Protocol) {
            this.IP = IP;
            this.Port = Port;
            this.Protocol = Protocol;
            }

        public String getIP() {
            if(!isOpen){
                return "noIP";
            }
            return IP;
        }
        public void setIP(String IP) {
            this.IP = IP;
        }

        public String getProtocol() {
            if(!isOpen){
                return "noProtocol";
            }
            return Protocol;
        }
        public void setProtocol(String protocol) {
            Protocol = protocol;
        }

        public String getPort() {
            if(!isOpen){
                return "noPort";
            }
            return Port;
        }
        public void setPort(String port) {
            Port = port;
        }

        public String connect() {
            if(numberOfConnections == numberOfConnectionsLimit){
                return "You cannot make anymore connections.";
            }
            return "A connection has been made.";
        }

        public String close() {
            isOpen = false;
            numberOfConnections--;
            return "A connection has been closed";
        }

        }
    }







