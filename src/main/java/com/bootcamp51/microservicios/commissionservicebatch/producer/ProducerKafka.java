package com.bootcamp51.microservicios.commissionservicebatch.producer;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerKafka {

 @Value("${spring.kafka.producer.topic}")
  private String topicProducer;

  private final KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  public ProducerKafka(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void produce(String message) {
    kafkaTemplate.send( topicProducer, message);
    System.out.printf("mensaje enviado: " + message);
  }



}
