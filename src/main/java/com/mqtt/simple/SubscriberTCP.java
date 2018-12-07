package com.mqtt.simple;

import org.eclipse.paho.client.mqttv3.MqttClient;

public class SubscriberTCP {
    public static void main(String[] args) throws Exception {
        System.out.println("== START SUBSCRIBER ==");

        String broker = "tcp://test.mosquitto.org";

        MqttClient client = new MqttClient(broker, MqttClient.generateClientId());
        client.setCallback(new MyMqttCallBack());

        client.connect();

        client.subscribe("test");
    }
}