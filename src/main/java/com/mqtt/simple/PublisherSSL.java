package com.mqtt.simple;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

public class PublisherSSL {

  public static void main(String[] args) throws Exception {
    System.out.println("== START PUBLISHER ==");

    String broker = "";//"ssl://test.mosquitto.org"

    String caCertFile = "./src/main/resources/server.crt";
    String clCertFile = "./src/main/resources/client.crt";
    String keyFile = "./src/main/resources/client.key";

    MqttClient client = new MqttClient(broker, MqttClient.generateClientId());
    MqttConnectOptions options = new MqttConnectOptions();
    options.setSocketFactory(SslUtil.getSocketFactory(caCertFile, clCertFile, keyFile, "password"));
    client.connect(options);

    String content = "Hello!";
    if (args.length == 2 ) {
      content = args[1];
    }
    MqttMessage message = new MqttMessage();
    message.setPayload(content.getBytes());

    client.publish("test", message);

    client.disconnect();

    System.out.println("== STOP PUBLISHER ==");
  }
}
