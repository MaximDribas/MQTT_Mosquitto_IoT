package com.mqtt.simple;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;


public class SubscriberSSL {

  public static void main(String[] args) throws Exception {
    System.out.println("== START SUBSCRIBER ==");

    String broker = "";//"ssl://test.mosquitto.org"

    String caCertFile = "./src/main/resources/server.crt";
    String clCertFile = "./src/main/resources/client.crt";
    String keyFile = "./src/main/resources/client.key";

    MqttClient client = new MqttClient(broker, MqttClient.generateClientId());
    client.setCallback(new MyMqttCallBack());

    MqttConnectOptions options = new MqttConnectOptions();
    options.setSocketFactory(SslUtil.getSocketFactory(caCertFile, clCertFile, keyFile, "password"));
    client.connect(options);//client.connect();

    client.subscribe("test");
  }
}

//String mqttUserName = "cpcc";
//String mqttPassword = "1qaz!QAZ1qaz";

//"tcp://test.mosquitto.org"
//options.setUserName(mqttUserName);
//options.setPassword(mqttPassword.toCharArray());
//SSLSocketFactory socketFactory = SslUtil.getSocketFactory(caFilePath, clientCrtFilePath, clientKeyFilePath, "1qaz!QAZ1qaz");

/*
  MqttClient client = new MqttClient(SSLAddress, MqttClient.generateClientId());
    client.setCallback(new MyMqttCallBack());

            MqttConnectOptions options = new MqttConnectOptions();
            Properties props = new Properties();
            props.setProperty("com.ibm.ssl.keyStore", caCertFile);
            props.setProperty("com.ibm.ssl.keyStore", certFile);
            props.setProperty("com.ibm.ssl.keyStore", keyFile);

            options.setSSLProperties(props);
            System.out.println(props);

            client.connect(options);//client.connect();

            client.subscribe("test");
*/
